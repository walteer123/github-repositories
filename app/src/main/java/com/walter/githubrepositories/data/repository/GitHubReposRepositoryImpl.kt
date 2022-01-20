package com.walter.githubrepositories.data.repository

import androidx.paging.PagingSource
import com.walter.githubrepositories.data.service.GitHubRepoDao
import com.walter.githubrepositories.domain.entity.GitHubRepo
import com.walter.githubrepositories.domain.repository.GitHubReposRepository

class GitHubReposRepositoryImpl(private val gitHubRepoDao: GitHubRepoDao) : GitHubReposRepository {
    override val pagingSource: PagingSource<Int, GitHubRepo>
        get() = gitHubRepoDao.getAllRepos()
}
