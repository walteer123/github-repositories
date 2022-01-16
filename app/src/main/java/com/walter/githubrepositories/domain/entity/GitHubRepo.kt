package com.walter.githubrepositories.domain.entity

data class GitHubRepo(
    val name: String,
    val totalStars: Int,
    val totalForks: Int,
    val avatarUrl: String,
    val authorName: String
)
