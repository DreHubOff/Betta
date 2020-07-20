package com.studying.bettamovies

import android.app.Application
import com.studying.bettamovies.db.DataBase

class App : Application() {
    lateinit var dataBase: DataBase

    override fun onCreate() {
        super.onCreate()
        dataBase = DataBase.getInstance(this)
    }
}