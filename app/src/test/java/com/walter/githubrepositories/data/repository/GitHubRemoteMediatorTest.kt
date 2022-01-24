package com.walter.githubrepositories.data.repository

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingConfig
import androidx.paging.PagingSource
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import com.walter.githubrepositories.data.entity.GitHubFixtures.getCustomGitHubRepoEntity
import com.walter.githubrepositories.di.mockedRemoteMediatorModules
import kotlin.test.assertTrue
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.test.KoinTest
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner

@ExperimentalPagingApi
@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class GitHubRemoteMediatorTest : KoinTest {

    private lateinit var remoteMediator: GitHubRepoRemoteMediator
    private val dispatchers = StandardTestDispatcher()

    @Before
    fun setup() = runTest {
        MockitoAnnotations.openMocks(this)
        Dispatchers.setMain(dispatchers)

        startKoin {
            modules(mockedRemoteMediatorModules)
        }

        remoteMediator = GitHubRepoRemoteMediator()
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
        stopKoin()
    }

    @Test
    fun `it should fetch data properly on refresh`() = runTest {
        val pagingSource = listOf(
            PagingSource
                .LoadResult
                .Page(
                    data = listOf(
                        getCustomGitHubRepoEntity(),
                        getCustomGitHubRepoEntity()
                    ),
                    prevKey = null,
                    nextKey = 1
                )
        )
        val result = remoteMediator.load(
            LoadType.REFRESH,
            PagingState(
                pages = pagingSource,
                anchorPosition = null,
                config = PagingConfig(pageSize = 30, prefetchDistance = 10),
                leadingPlaceholderCount = 10
            )
        )
        assertTrue { result is RemoteMediator.MediatorResult.Success }
    }

}
