package com.studying.bettamovies

import android.app.Application
import com.studying.bettamovies.data.ModelConverter
import com.studying.bettamovies.data.Repository
import com.studying.bettamovies.db.DataBase

class App : Application() {
    lateinit var dataBase: DataBase
    lateinit var repository: Repository

    override fun onCreate() {
        super.onCreate()
        dataBase = DataBase.getInstance(this)
        repository = Repository(dataBase, ModelConverter())
    }
}