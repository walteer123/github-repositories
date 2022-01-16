package com.walter.githubrepositories.data.entity

import com.squareup.moshi.Json
import com.walter.githubrepositories.domain.entity.GitHubRepo

data class GithubRepoRemote(
    @field:Json(name = "name") val name: String,
    @field:Json(name = "owner") val owner: RepoOwnerRemote,
    @field:Json(name = "forks_count") val totalForks: Int,
    @field:Json(name = "stargazers_count") val totalStars: Int
){
    fun transform() = GitHubRepo(
        name = name,
        authorName = owner.login,
        avatarUrl = owner.avatarUrl,
        totalForks = totalForks,
        totalStars = totalStars
    )
}
