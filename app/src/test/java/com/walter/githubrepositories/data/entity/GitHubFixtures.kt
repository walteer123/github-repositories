package com.walter.githubrepositories.data.entity

import com.walter.githubrepositories.data.entity.local.GitHubRepoEntity
import com.walter.githubrepositories.domain.entity.GitHubRepo

object GitHubFixtures {

    fun getDummyRepoResponseRemote() = GitHubRepoResponseRemote(
        totalItems = 2,
        repositories = listOf(
            getDummyRepoRemote(),
            getDummyRepoRemote(id = 2, name = "ble")
        )
    )

    fun getDummyRepoRemote(
        id: Int = 1,
        name: String = "bla",
        ownerRemote: RepoOwnerRemote = RepoOwnerRemote("owner", "bla"),
        totalForks: Int = 1,
        totalStars: Int = 1
    ) = GithubRepoRemote(
        id = id,
        name = name,
        owner = ownerRemote,
        totalForks = totalForks,
        totalStars = totalStars
    )

    fun getCustomGitHubRepoEntity(
        id: Int = 1,
        name: String = "Repo",
        authorName: String = "Walter",
        avatarUrl: String = "avatar",
        totalForks: Int = 1,
        totalStars: Int = 1

    ) = GitHubRepoEntity(
        id,
        name,
        authorName,
        avatarUrl,
        totalForks,
        totalStars
    )
}