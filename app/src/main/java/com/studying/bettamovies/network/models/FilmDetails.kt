package com.studying.bettamovies.network.models

import com.google.gson.annotations.SerializedName

data class FilmDetails(
    @SerializedName("backdrop_path")
    val backdropImageURL: String,
    @SerializedName("budget")
    val budget: Int,
    @SerializedName("genres")
    val genres: List<Genre>,
    @SerializedName("homepage")
    val homepage: String,
    @SerializedName("original_language")
    val originalLanguage: String,
    @SerializedName("overview")
    val overview: String,
    @SerializedName("release_date")
    val releaseDate: String,
    @SerializedName("runtime")
    val runtime: Int,
    @SerializedName("voteAverage")
    var voteAverage: Float,
    @SerializedName("voteCount")
    var voteCount: Int
)

data class Genre(
    @SerializedName("name")
    var GenreName: String
)