package com.walter.githubrepositories.presentation

import androidx.paging.ExperimentalPagingApi
import androidx.paging.PagingData
import androidx.paging.map
import app.cash.turbine.test
import com.walter.githubrepositories.domain.DomainFixtures.getCustomGitHubRepo
import com.walter.githubrepositories.domain.repository.GitHubReposRepository
import com.walter.githubrepositories.presentation.repos.GitHubReposViewModel
import kotlin.test.assertEquals
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class GitHubReposViewModelTest {

    @Mock
    private lateinit var repository: GitHubReposRepository

    private lateinit var viewModel: GitHubReposViewModel

    private val dispatcher = StandardTestDispatcher()

    @Before
    fun setup() {
        Dispatchers.setMain(dispatcher)
        MockitoAnnotations.openMocks(this)
        viewModel = GitHubReposViewModel(repository)
    }

    @ExperimentalPagingApi
    @Test
    fun `it should collect data properly`() = runTest {
        Mockito.`when`(repository.getGitHubRepoPagingFlow()).thenReturn(
            flowOf(PagingData.from(listOf(getCustomGitHubRepo())))
        )

        viewModel.getReposFlow().test(3_000) {
            awaitItem().map { repo ->
                assertEquals(repo, getCustomGitHubRepo())
            }
        }
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }
}
