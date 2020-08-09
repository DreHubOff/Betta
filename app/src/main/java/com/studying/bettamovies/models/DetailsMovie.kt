package com.studying.bettamovies.models

import android.net.Uri

data class DetailsMovie(
    val popularity: String,
    val releaseDate: String,
    val runtime: String,
    val genres: String,
    val budget: String,
    val overview: String,
    val homepage: String,
    val backdropURL: Uri,
    val originalLanguage: String,
    val originalTitle: String,
    val adult: String,
    val productionCompanies: String,
    val spokenLanguages: String,
    val netId: Int
)



