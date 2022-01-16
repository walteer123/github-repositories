package com.walter.githubrepositories.presentation.repos

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import androidx.paging.map
import com.walter.githubrepositories.data.repository.GithubRepoPagingSource
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class GitHubReposViewModel : ViewModel() {

    val reposDataFlow = Pager(
        PagingConfig(
            pageSize = 100,
            prefetchDistance = 20
        )
    ) {
        GithubRepoPagingSource()
    }.flow
        .cachedIn(viewModelScope)


    init {
        viewModelScope.launch {
            reposDataFlow.collect {
                it.map {
                    it
                }
            }
        }

    }

}
