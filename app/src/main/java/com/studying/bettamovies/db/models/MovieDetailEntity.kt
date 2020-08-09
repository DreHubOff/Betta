package com.studying.bettamovies.db.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class MovieDetailEntity(
    @ColumnInfo(name = "poster_path")
    val poster_path: String,
    @ColumnInfo(name = "budget")
    val budget: Int,
    @ColumnInfo(name = "genres")
    val genres: String,
    @ColumnInfo(name = "homepage")
    val homepage: String,
    @ColumnInfo(name = "original_language")
    val originalLanguage: String,
    @ColumnInfo(name = "original_title")
    val originalTitle: String,
    @ColumnInfo(name = "overview")
    val overview: String,
    @ColumnInfo(name = "popularity")
    val popularity: Double,
    @ColumnInfo(name = "release_date")
    val releaseDate: String,
    @ColumnInfo(name = "runtime")
    val runtime: Int,
    @ColumnInfo(name = "adult")
    val adult: Boolean,
    @ColumnInfo(name = "production_companies")
    val productionCompanies: String,
    @ColumnInfo(name = "spoken_languages")
    val spokenLanguages: String,
    @ColumnInfo(name = "net_id")
    val netId: Int,

    @PrimaryKey(autoGenerate = true)
    var _ID: Long? = null
)
