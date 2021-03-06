package com.walter.githubrepositories.data.entity

import com.google.gson.annotations.SerializedName

data class GitHubRepoResponseRemote(
    @SerializedName("total_count") val totalItems: Int,
    @SerializedName("items") val repositories: List<GithubRepoRemote>
)
