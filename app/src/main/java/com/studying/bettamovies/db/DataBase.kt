package com.studying.bettamovies.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.studying.bettamovies.db.dao.MovieDetailsEntityDao
import com.studying.bettamovies.db.dao.MovieItemEntityDao
import com.studying.bettamovies.db.models.MovieDetailEntity
import com.studying.bettamovies.db.models.MovieItemEntity

@Database(entities = [MovieItemEntity::class, MovieDetailEntity::class], version = 1, exportSchema = false)
abstract class DataBase : RoomDatabase() {
    abstract fun getMovieItemDao(): MovieItemEntityDao
    abstract fun getMovieDetailsDao(): MovieDetailsEntityDao

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