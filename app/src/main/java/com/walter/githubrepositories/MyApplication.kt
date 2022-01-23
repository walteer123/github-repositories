package com.walter.githubrepositories

import android.app.Application
import androidx.paging.ExperimentalPagingApi

@ExperimentalPagingApi
class MyApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        start(this)
    }
}
