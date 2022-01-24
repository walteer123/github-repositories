package com.walter.githubrepositories.data.service

import androidx.paging.PagingSource
import androidx.room.DatabaseConfiguration
import androidx.room.InvalidationTracker
import androidx.sqlite.db.SupportSQLiteOpenHelper
import com.walter.githubrepositories.data.entity.local.GitHubRepoEntity
import com.walter.githubrepositories.data.entity.local.RemoteKey
import com.walter.githubrepositories.data.repository.MockedPagingSource
import com.walter.githubrepositories.database.GitHubRepoDatabase
import com.walter.githubrepositories.domain.entity.GitHubRepo
import kotlinx.coroutines.Dispatchers

class MockedKeysDao : RemoteKeyDao {
    override suspend fun insertAll(remoteKey: List<RemoteKey>) {

    }

    override suspend fun remoteKeysRepoId(id: Int): RemoteKey? {
        return RemoteKey(
            repoId = 1,
            nextKey = 1,
            prevKey = 0
        )
    }

    override suspend fun deleteAll() {

    }
}

class MockedGitHubRepoDao: GitHubRepoDao {
    override fun getAllRepos(): PagingSource<Int, GitHubRepoEntity> {
        return MockedPagingSource(Dispatchers.IO)
    }

    override fun deleteAllRepos() {

    }

    override fun insertAllRepos(repos: List<GitHubRepoEntity>) {

    }
}