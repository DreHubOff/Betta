package com.studying.bettamovies.db.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class MovieEntity(
    @ColumnInfo(name = "popularity")
    val popularity: Double,
    @ColumnInfo(name = "image")
    val image: String,
    @ColumnInfo(name = "movie_id")
    val movieID: String,
    @ColumnInfo(name = "original_title")
    val originalTitle: String,
    @ColumnInfo(name = "language")
    val language: String,

    @ColumnInfo(name = "genres")
    var genres: String? = null,
    @ColumnInfo(name = "budget")
    var budget: Int = 0,
    @ColumnInfo(name = "homepage")
    var homepage: String? = null,
    @ColumnInfo(name = "overview")
    var overview: String? = null,
    @ColumnInfo(name = "release_date")
    var releaseDate: String? = null,
    @ColumnInfo(name = "runtime")
    var runtime: Int = 0,

    @PrimaryKey(autoGenerate = true)
    var _ID: Long? = null
)