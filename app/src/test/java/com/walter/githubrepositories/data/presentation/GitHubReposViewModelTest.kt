package com.walter.githubrepositories.data.presentation

import androidx.paging.PagingData
import com.walter.githubrepositories.domain.repository.GitHubReposRepository
import com.walter.githubrepositories.presentation.repos.GitHubReposViewModel
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class GitHubReposViewModelTest {

    @Mock
    private lateinit var repository: GitHubReposRepository

    private lateinit var viewModel: GitHubReposViewModel

    @Before
    fun setup() {
        viewModel = GitHubReposViewModel(repository)
    }

    @Test
    fun `dadsjndhjasd`() = runBlocking {
        Mockito.`when`(repository.getGitHubRepoPagingFlow()).thenReturn(
            flowOf(
                PagingData.from(listOf())
            )
        )


    }


}
