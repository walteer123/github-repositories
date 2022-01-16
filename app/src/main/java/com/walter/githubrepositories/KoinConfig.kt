package com.walter.githubrepositories

import android.app.Application
import com.walter.githubrepositories.di.networkModule
import com.walter.githubrepositories.di.presentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.loadKoinModules
import org.koin.core.context.startKoin

fun start(myApplication: Application) {
    startKoin { androidContext(myApplication) }
    injectModules()
}

fun injectModules() = loadKoinModules

private val loadKoinModules by lazy {
    loadKoinModules(
        listOf(
            networkModule,
            presentationModule
        )
    )
}
