package com.walter.githubrepositories.data.entity.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.walter.githubrepositories.domain.entity.GitHubRepo

@Entity(tableName = "GitHubRepo")
data class GitHubRepoEntity(
    @PrimaryKey
    val id: Int,
    val name: String,
    val authorName: String,
    val avatarUrl: String,
    val totalForks: Int,
    val totalStars: Int
) {
    fun transform() = GitHubRepo(
        id = id,
        name = name,
        authorName = authorName,
        avatarUrl = avatarUrl,
        totalForks = totalForks,
        totalStars = totalStars
    )
}
