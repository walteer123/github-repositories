package com.walter.githubrepositories.data.service

import com.walter.githubrepositories.data.entity.GitHubFixtures.getDummyRepoResponseRemote
import com.walter.githubrepositories.data.entity.GitHubRepoResponseRemote

class MockedGitHubService: GithubService {
    override suspend fun getGithubRepositories(
        query: String,
        page: Int?,
        loadSize: Int,
        sort: String
    ): GitHubRepoResponseRemote {
        return getDummyRepoResponseRemote()
    }
}