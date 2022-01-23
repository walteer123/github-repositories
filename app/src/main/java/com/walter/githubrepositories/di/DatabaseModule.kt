package com.walter.githubrepositories.di

import androidx.room.Room
import com.walter.githubrepositories.database.GitHubRepoDatabase
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val databaseModule = module {
    single {
        Room.databaseBuilder(
            androidApplication(),
            GitHubRepoDatabase::class.java,
            "GitHubRepos.db"
        )
            .fallbackToDestructiveMigration()
            .build()
    }
    single { get<GitHubRepoDatabase>().getGitHubRepoDao() }
    single { get<GitHubRepoDatabase>().getKeysDao() }
}