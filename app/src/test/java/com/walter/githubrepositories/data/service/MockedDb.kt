package com.walter.githubrepositories.data.service

import androidx.paging.PagingSource
import androidx.room.DatabaseConfiguration
import androidx.room.InvalidationTracker
import androidx.sqlite.db.SupportSQLiteOpenHelper
import com.walter.githubrepositories.data.entity.local.RemoteKey
import com.walter.githubrepositories.database.GitHubRepoDatabase
import com.walter.githubrepositories.domain.entity.GitHubRepo

class MockedDb : GitHubRepoDatabase() {
    override fun getKeysDao(): RemoteKeyDao {
        return MockedKeysDao()
    }

    override fun getGitHubRepoDao(): GitHubRepoDao {
        TODO("Not yet implemented")
    }

    override fun createOpenHelper(config: DatabaseConfiguration?): SupportSQLiteOpenHelper {
       return super.getOpenHelper()
    }

    override fun createInvalidationTracker(): InvalidationTracker {
        return super.getInvalidationTracker()
    }

    override fun clearAllTables() {

    }
}

class MockedKeysDao() : RemoteKeyDao {
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
    override fun getAllRepos(): PagingSource<Int, GitHubRepo> {
        TODO("Not yet implemented")
    }

    override fun deleteAllRepos() {
        TODO("Not yet implemented")
    }

    override fun insertAllRepos(repos: List<GitHubRepo>) {
        TODO("Not yet implemented")
    }
}