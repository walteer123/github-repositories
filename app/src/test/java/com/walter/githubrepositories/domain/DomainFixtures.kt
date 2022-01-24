package com.walter.githubrepositories.domain

import com.walter.githubrepositories.domain.entity.GitHubRepo

object DomainFixtures {

    fun getCustomGitHubRepo(
        id: Int = 1,
        name: String = "Repo",
        authorName: String = "Walter",
        avatarUrl: String = "avatar",
        totalForks: Int = 1,
        totalStars: Int = 1

    ) = GitHubRepo(
        id,
        name,
        authorName,
        avatarUrl,
        totalForks,
        totalStars
    )
}
