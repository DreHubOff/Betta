package com.studying.bettamovies.network.models

import com.google.gson.annotations.SerializedName

data class FilmDetails(
    @SerializedName("backdropPath")
    val backdropImageURL: String,
    @SerializedName("budget")
    val budget: Int,
    @SerializedName("genres")
    val genres: List<Genre>,
    @SerializedName("homepage")
    val homepage: String,
    @SerializedName("originalLanguage")
    val originalLanguage: String,
    @SerializedName("overview")
    val overview: String,
    @SerializedName("releaseDate")
    val releaseDate: String,
    @SerializedName("runtime")
    val runtime: Int,
    @SerializedName("voteAverage")
    var voteAverage: Float,
    @SerializedName("voteCount")
    var voteCount: Int
)

data class Genre(
    @SerializedName("id")
    var GenreId: Int,
    @SerializedName("name")
    var GenreName: String
)