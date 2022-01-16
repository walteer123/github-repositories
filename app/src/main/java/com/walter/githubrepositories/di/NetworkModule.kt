package com.walter.githubrepositories.di

import com.walter.githubrepositories.data.service.GithubService
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

val networkModule = module {
    single {
        Retrofit.Builder()
            .baseUrl("https://api.github.com/")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }

    single {
        get<Retrofit>().create(GithubService::class.java)
    }
}
