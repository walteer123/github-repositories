package com.walter.githubrepositories.di

import com.walter.githubrepositories.data.repository.GitHubReposRepositoryImpl
import com.walter.githubrepositories.domain.repository.GitHubReposRepository
import org.koin.dsl.module

val dataModule = module {
    single<GitHubReposRepository> { GitHubReposRepositoryImpl(get()) }
}