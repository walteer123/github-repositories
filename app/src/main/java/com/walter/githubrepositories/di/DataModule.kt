package com.walter.githubrepositories.di

import androidx.paging.ExperimentalPagingApi
import com.walter.githubrepositories.data.repository.GitHubReposRepositoryImpl
import com.walter.githubrepositories.domain.repository.GitHubReposRepository
import org.koin.dsl.module

@ExperimentalPagingApi
val dataModule = module {
    single<GitHubReposRepository> { GitHubReposRepositoryImpl(get()) }
}