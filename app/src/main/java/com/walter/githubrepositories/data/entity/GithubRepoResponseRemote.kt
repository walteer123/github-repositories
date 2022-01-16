package com.walter.githubrepositories.data.entity

import com.squareup.moshi.Json

data class GithubRepoResponseRemote(
    @field:Json(name = "total_count") val totalItems: Int,
    @field:Json(name = "items") val repositories: List<GithubRepoRemote>,
)
