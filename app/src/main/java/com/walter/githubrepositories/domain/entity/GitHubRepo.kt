package com.walter.githubrepositories.domain.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "GitHubRepo")
data class GitHubRepo(
    @PrimaryKey val id: Int,
    val name: String,
    val authorName: String,
    val avatarUrl: String,
    val totalForks: Int,
    val totalStars: Int
)
