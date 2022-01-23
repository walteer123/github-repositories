package com.walter.githubrepositories

import android.app.Application
import androidx.paging.ExperimentalPagingApi
import com.walter.githubrepositories.di.dataModule
import com.walter.githubrepositories.di.databaseModule
import com.walter.githubrepositories.di.networkModule
import com.walter.githubrepositories.di.presentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.loadKoinModules
import org.koin.core.context.startKoin

@ExperimentalPagingApi
fun start(myApplication: Application) {
    startKoin { androidContext(myApplication) }
    injectModules()
}

@ExperimentalPagingApi
fun injectModules() = loadKoinModules

@ExperimentalPagingApi
private val loadKoinModules by lazy {
    loadKoinModules(
        listOf(
            networkModule,
            presentationModule,
            databaseModule,
            dataModule
        )
    )
}
