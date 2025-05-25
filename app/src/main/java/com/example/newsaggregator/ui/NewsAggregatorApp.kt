package com.example.newsaggregator.ui

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class NewsAggregatorApp : Application() {

    override fun onCreate() {
        super.onCreate()
    }
}