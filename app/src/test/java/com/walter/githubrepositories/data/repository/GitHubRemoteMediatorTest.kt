package com.walter.githubrepositories.data.repository

import androidx.paging.ExperimentalPagingApi
import com.walter.githubrepositories.di.mockedRemoteMediatorModules
import org.junit.Before
import org.junit.runner.RunWith
import org.koin.core.context.startKoin
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class GitHubRemoteMediatorTest {

    @ExperimentalPagingApi
    private lateinit var remoteMediator: GitHubRepoRemoteMediator

    @Before
    fun setup() {
        startKoin { modules(mockedRemoteMediatorModules) }
    }

}
