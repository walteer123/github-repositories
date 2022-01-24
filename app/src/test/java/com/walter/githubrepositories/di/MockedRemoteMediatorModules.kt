package com.walter.githubrepositories.di

import com.walter.githubrepositories.data.service.GitHubRepoDao
import com.walter.githubrepositories.data.service.GithubService
import com.walter.githubrepositories.data.service.MockedGitHubRepoDao
import com.walter.githubrepositories.data.service.MockedGitHubService
import com.walter.githubrepositories.data.service.MockedKeysDao
import com.walter.githubrepositories.data.service.RemoteKeyDao
import org.koin.dsl.module

val mockedRemoteMediatorModules = module {
    single<GithubService> { MockedGitHubService() }
    single<RemoteKeyDao> { MockedKeysDao() }
    single<GitHubRepoDao> { MockedGitHubRepoDao() }
}
