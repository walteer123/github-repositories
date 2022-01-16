package com.walter.githubrepositories.presentation.repos

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.walter.githubrepositories.data.repository.GithubRepoPagingSource

class GitHubReposViewModel : ViewModel() {

    val reposDataFlow = Pager(
        PagingConfig(
            pageSize = 30,
            prefetchDistance = 10
        )
    ) {
        GithubRepoPagingSource()
    }.flow
        .cachedIn(viewModelScope)

}
