package com.beacheslav.myapplication

import android.app.Application
import android.content.Context

var appContext: Context? = null

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        appContext = this
    }

}
