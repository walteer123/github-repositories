package com.walter.githubrepositories.data.service

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.walter.githubrepositories.data.entity.local.RemoteKey

@Dao
interface RemoteKeyDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(remoteKey: List<RemoteKey>)

    @Query("SELECT * FROM  remote_keys WHERE repoId = :id")
    suspend fun remoteKeysRepoId(id: Int): RemoteKey?

    @Query("DELETE FROM remote_keys")
    suspend fun deleteAll()
}
