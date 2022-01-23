package com.walter.githubrepositories.presentation.repos

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.walter.githubrepositories.data.repository.GitHubRepoRemoteMediator
import com.walter.githubrepositories.domain.repository.GitHubReposRepository

class GitHubReposViewModel(private val repository: GitHubReposRepository) : ViewModel() {

    @ExperimentalPagingApi
    fun getReposFlow() = repository.getGitHubRepoPagingFlow()
        .cachedIn(viewModelScope)

}
