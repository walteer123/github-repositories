package com.walter.githubrepositories.di

import com.walter.githubrepositories.data.service.GithubService
import com.walter.githubrepositories.network.GitHubApiServiceFactory
import com.walter.githubrepositories.network.GitHubOkHttpClientFactory
import com.walter.githubrepositories.network.OkHttpClientFactory
import org.koin.dsl.module

val networkModule = module {
    factory <OkHttpClientFactory>{ GitHubOkHttpClientFactory() }
    single { GitHubApiServiceFactory(get()) }
    single { get<GitHubApiServiceFactory>().create(GithubService::class.java) }
}
