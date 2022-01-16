package com.walter.githubrepositories.data.entity

import com.squareup.moshi.Json

data class RepoOwnerRemote(
    @field:Json(name = "login") val login: String,
    @field:Json(name = "avatar_url") val avatarUrl: String,
)
