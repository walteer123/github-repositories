package com.walter.githubrepositories.data.repository

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.PagingSource
import androidx.paging.map
import com.walter.githubrepositories.data.service.GitHubRepoDao
import com.walter.githubrepositories.domain.entity.GitHubRepo
import com.walter.githubrepositories.domain.repository.GitHubReposRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

@ExperimentalPagingApi
class GitHubReposRepositoryImpl(private val gitHubRepoDao: GitHubRepoDao) : GitHubReposRepository {

    override fun getGitHubRepoPagingFlow(): Flow<PagingData<GitHubRepo>> = Pager(
        config = PagingConfig(
            pageSize = 30,
            prefetchDistance = 10
        ),
        remoteMediator = GitHubRepoRemoteMediator()
    ) {
        gitHubRepoDao.getAllRepos()
    }.flow.map { pagingData ->
        pagingData.map { it.transform() }
    }

}
