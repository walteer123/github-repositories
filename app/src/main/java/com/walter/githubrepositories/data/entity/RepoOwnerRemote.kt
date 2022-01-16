package com.walter.githubrepositories.data.entity

import com.google.gson.annotations.SerializedName


data class RepoOwnerRemote(
    @SerializedName("login") val login: String,
    @SerializedName("avatar_url") val avatarUrl: String,
)
