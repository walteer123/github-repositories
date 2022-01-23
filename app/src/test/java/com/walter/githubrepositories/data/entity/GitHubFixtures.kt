package com.walter.githubrepositories.data.entity

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
}