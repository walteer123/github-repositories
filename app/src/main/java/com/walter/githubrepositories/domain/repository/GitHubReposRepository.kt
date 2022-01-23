package com.walter.githubrepositories.domain.repository

import androidx.paging.PagingData
import androidx.paging.PagingSource
import com.walter.githubrepositories.domain.entity.GitHubRepo
import kotlinx.coroutines.flow.Flow

interface GitHubReposRepository {
    fun getGitHubRepoPagingFlow(): Flow<PagingData<GitHubRepo>>
}