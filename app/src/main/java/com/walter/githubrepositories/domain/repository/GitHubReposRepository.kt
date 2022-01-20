package com.walter.githubrepositories.domain.repository

import androidx.paging.PagingSource
import com.walter.githubrepositories.domain.entity.GitHubRepo

interface GitHubReposRepository {
    val pagingSource: PagingSource<Int, GitHubRepo>
}