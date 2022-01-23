package com.walter.githubrepositories.domain.entity

data class GitHubRepo(
    val id: Int,
    val name: String,
    val authorName: String,
    val avatarUrl: String,
    val totalForks: Int,
    val totalStars: Int
)
