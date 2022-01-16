package com.walter.githubrepositories.data.service

import com.walter.githubrepositories.data.entity.GithubRepoResponseRemote
import retrofit2.http.GET
import retrofit2.http.Query

interface GithubService {

    @GET("search/repositories")
    suspend fun getGithubRepositories(
        @Query("q") query: String = "language:kotlin",
        @Query("page") page: Int
    ): GithubRepoResponseRemote
}