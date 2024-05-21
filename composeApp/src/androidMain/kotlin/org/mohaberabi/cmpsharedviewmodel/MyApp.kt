package org.mohaberabi.cmpsharedviewmodel

import KoinInit
import android.app.Application

class MyApp : Application() {


    override fun onCreate() {
        super.onCreate()
        KoinInit(applicationContext).init()
    }
}