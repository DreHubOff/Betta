package com.studying.bettamovies.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.studying.bettamovies.db.models.MovieEntity

@Database(entities = [MovieEntity::class], version = 1, exportSchema = false)
abstract class DataBase : RoomDatabase() {
    abstract fun getActivityDao(): ActivityEntityDao

    companion object {
        fun getInstance(context: Context) = Room.databaseBuilder(
            context.applicationContext,
            DataBase::class.java,
            "movies"
        ).fallbackToDestructiveMigration()
            .allowMainThreadQueries()
            .build()
    }
}