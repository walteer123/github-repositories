package com.walter.githubrepositories.domain.entity

data class GitHubRepo(
    private val name: String,
    private val totalStars: Int,
    private val totalForks: Int,
    private val avatarUrl: String,
    private val authorName: String
)
