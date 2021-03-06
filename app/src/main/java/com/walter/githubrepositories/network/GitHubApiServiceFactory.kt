package com.walter.githubrepositories.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class GitHubApiServiceFactory(
    okHttpClientFactory: OkHttpClientFactory,
) : ServiceFactory {
    private val retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl("https://api.github.com/")
        .client(okHttpClientFactory.create())
        .build()

    override fun <T> create(service: Class<T>): T = retrofit.create(service)
}
