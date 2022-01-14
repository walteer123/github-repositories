package com.walter.githubrepositories

import android.app.Application

class MyApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        start(this)
    }
}
