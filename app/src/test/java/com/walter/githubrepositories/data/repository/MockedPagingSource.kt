package com.walter.githubrepositories.data.repository

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.walter.githubrepositories.data.entity.GitHubFixtures.getCustomGitHubRepoEntity
import com.walter.githubrepositories.data.entity.local.GitHubRepoEntity
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

class MockedPagingSource(private val dispatchers: CoroutineDispatcher) :
    PagingSource<Int, GitHubRepoEntity>() {

    override fun getRefreshKey(state: PagingState<Int, GitHubRepoEntity>): Int? = null

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, GitHubRepoEntity> =
        withContext(dispatchers) {
            try {
                val page = params.key ?: 0
                val repositories = listOf(getCustomGitHubRepoEntity())

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
