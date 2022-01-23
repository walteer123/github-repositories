package com.walter.githubrepositories.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.walter.githubrepositories.data.entity.local.GitHubRepoEntity
import com.walter.githubrepositories.data.entity.local.RemoteKey
import com.walter.githubrepositories.data.service.GitHubRepoDao
import com.walter.githubrepositories.data.service.RemoteKeyDao
import com.walter.githubrepositories.domain.entity.GitHubRepo

@Database(version = 3, entities = [RemoteKey::class, GitHubRepoEntity::class])
abstract class GitHubRepoDatabase : RoomDatabase(){
    abstract fun getKeysDao(): RemoteKeyDao
    abstract fun getGitHubRepoDao(): GitHubRepoDao
}
