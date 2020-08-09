package com.studying.bettamovies.db.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class MovieItemEntity(
    @ColumnInfo(name = "poster_url")
    val posterURL: String,
    @ColumnInfo(name = "movie_id")
    val netId: Int,
    @ColumnInfo(name = "title")
    val title: String,

    @PrimaryKey(autoGenerate = true)
    var _ID: Long? = null
)