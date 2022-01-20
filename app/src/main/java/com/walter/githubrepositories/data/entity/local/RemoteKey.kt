package com.walter.githubrepositories.data.entity.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "remote_keys")
data class RemoteKey(
    @PrimaryKey val repoId: Int,
    val prevKey: Int?,
    val nextKey: Int?
)
