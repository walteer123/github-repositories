package com.walter.githubrepositories.data.entity

import com.google.gson.annotations.SerializedName
import com.walter.githubrepositories.domain.entity.GitHubRepo

data class GithubRepoRemote(
    @SerializedName("name") val name: String,
    @SerializedName("owner") val owner: RepoOwnerRemote,
    @SerializedName("forks_count") val totalForks: Int,
    @SerializedName("stargazers_count") val totalStars: Int
) {
    fun transform() = GitHubRepo(
        name = name,
        authorName = owner.login,
        avatarUrl = owner.avatarUrl,
        totalForks = totalForks,
        totalStars = totalStars
    )
}
