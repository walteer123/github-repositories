package com.walter.githubrepositories.data.service

import com.walter.githubrepositories.data.entity.GithubRepoResponseRemote
import retrofit2.http.GET
import retrofit2.http.Query

interface GithubService {

    @GET("search/repositories")
    suspend fun getGithubRepositories(
        @Query("q") query: String,
        @Query("page") page: Int?,
        @Query("per_page") loadSize: Int,
        @Query("sort") sort: String,
    ): GithubRepoResponseRemote
}