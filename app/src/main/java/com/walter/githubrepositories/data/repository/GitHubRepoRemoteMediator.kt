package com.walter.githubrepositories.data.repository

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import androidx.room.withTransaction
import com.walter.githubrepositories.data.entity.GitQueryLanguage
import com.walter.githubrepositories.data.entity.GitSortType
import com.walter.githubrepositories.data.entity.local.GitHubRepoEntity
import com.walter.githubrepositories.data.entity.local.RemoteKey
import com.walter.githubrepositories.data.service.GithubService
import com.walter.githubrepositories.database.GitHubRepoDatabase
import com.walter.githubrepositories.domain.entity.GitHubRepo
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

@ExperimentalPagingApi
class GitHubRepoRemoteMediator : RemoteMediator<Int, GitHubRepoEntity>(), KoinComponent {

    private val service: GithubService by inject()
    private val db: GitHubRepoDatabase by inject()

    override suspend fun initialize(): InitializeAction {
        return InitializeAction.LAUNCH_INITIAL_REFRESH
    }

    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, GitHubRepoEntity>
    ): MediatorResult {
        return try {
            val loadKey = getKeyPageData(loadType, state)
            val page = when (loadKey) {
                is MediatorResult.Success -> {
                    return loadKey
                }
                else -> {
                    loadKey as Int
                }
            }

            val data = service.getGithubRepositories(
                query = GitQueryLanguage.KOTLIN.value,
                page = page,
                sort = GitSortType.STARS.value,
                loadSize = state.config.pageSize
            )
                .repositories
                .map { it.transform() }
            val endOfList = data.isEmpty()

            if (loadType == LoadType.REFRESH) {
                db.withTransaction {
                    db.getKeysDao().deleteAll()
                    db.getGitHubRepoDao().deleteAllRepos()
                }
            }

            val prev = if (page == 0) null else page - 1
            val next = if (endOfList) null else page + 1

            db.withTransaction {
                val remoteKeys = data.map { repo ->
                    RemoteKey(
                        repoId = repo.id,
                        prevKey = prev,
                        nextKey = next
                    )
                }

                db.getKeysDao().insertAll(remoteKeys)
                db.getGitHubRepoDao().insertAllRepos(data)
            }

            return MediatorResult.Success(endOfPaginationReached = endOfList)
        } catch (exception: Exception) {
            MediatorResult.Error(exception)
        }
    }

    private suspend fun getClosestKey(state: PagingState<Int, GitHubRepoEntity>): RemoteKey? {
        return state?.anchorPosition?.let {
            state?.closestItemToPosition(it)?.run {
                db.getKeysDao().remoteKeysRepoId(id)
            }
        }
    }

    private suspend fun getLastKey(state: PagingState<Int, GitHubRepoEntity>): RemoteKey? {
        state.pages
        return state.pages
            .lastOrNull { it.data.isNotEmpty() }
            ?.data?.lastOrNull()
            ?.run {
                db.getKeysDao().remoteKeysRepoId(id)
            }
    }

    private suspend fun getFirstRemoteKey(state: PagingState<Int, GitHubRepoEntity>): RemoteKey? {
        return state.pages
            .firstOrNull { it.data.isNotEmpty() }
            ?.data?.firstOrNull()
            ?.run { db.getKeysDao().remoteKeysRepoId(id) }
    }

    private suspend fun getKeyPageData(
        loadType: LoadType,
        state: PagingState<Int, GitHubRepoEntity>
    ): Any {
        return when (loadType) {
            LoadType.REFRESH -> {
                val remoteKeys = getClosestKey(state)
                remoteKeys?.nextKey?.minus(1) ?: 0
            }
            LoadType.APPEND -> {
                val remoteKeys = getLastKey(state)
                val nextKey = remoteKeys?.nextKey
                return nextKey ?: MediatorResult.Success(endOfPaginationReached = false)
            }
            LoadType.PREPEND -> {
                val remoteKeys = getFirstRemoteKey(state)
                val prevKey = remoteKeys?.prevKey ?: return MediatorResult.Success(
                    endOfPaginationReached = false
                )
                prevKey
            }
        }
    }
}
