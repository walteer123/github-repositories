package com.walter.githubrepositories.data.service

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.walter.githubrepositories.data.entity.local.GitHubRepoEntity

@Dao
interface GitHubRepoDao {

    @Query("SELECT * FROM GitHubRepo ORDER BY totalStars DESC")
    fun getAllRepos(): PagingSource<Int, GitHubRepoEntity>

    @Query("DELETE FROM githubrepo")
    fun deleteAllRepos()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllRepos(repos: List<GitHubRepoEntity>)
}
