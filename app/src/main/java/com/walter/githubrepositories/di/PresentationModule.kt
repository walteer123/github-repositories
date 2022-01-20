package com.walter.githubrepositories.di


import com.walter.githubrepositories.presentation.repos.GitHubReposViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {
    viewModel { GitHubReposViewModel(get()) }
}