package com.walter.githubrepositories.data.repository

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.walter.githubrepositories.data.service.GithubService
import com.walter.githubrepositories.domain.entity.GitHubRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class GithubRepoPagingSource : PagingSource<Int, GitHubRepo>(), KoinComponent {

    private val service: GithubService by inject()

    override fun getRefreshKey(state: PagingState<Int, GitHubRepo>): Int? = null

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, GitHubRepo> =
        withContext(Dispatchers.IO) {
            try {
                val page = params.key ?: 0
                val repositories = service.getGithubRepositories(page = page)
                    .repositories
                    .map { it.transform() }

                LoadResult.Page(
                    data = repositories,
                    prevKey = null,
                    nextKey = if (repositories.isEmpty()) null else page + 1
                )
            } catch (exception: Throwable) {
                LoadResult.Error(exception)
            }
        }

}