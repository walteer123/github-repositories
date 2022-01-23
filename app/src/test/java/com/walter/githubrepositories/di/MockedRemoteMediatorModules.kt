package com.walter.githubrepositories.di

import com.walter.githubrepositories.data.service.GithubService
import com.walter.githubrepositories.data.service.MockedGitHubService
import com.walter.githubrepositories.database.GitHubRepoDatabase
import org.koin.dsl.module


val mockedRemoteMediatorModules = module {
    single <GithubService>{ MockedGitHubService() }
    single <GitHubRepoDatabase>{}
    private val service: GithubService by inject()
    private val db: GitHubRepoDatabase by inject()
}

