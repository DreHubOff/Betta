package com.studying.bettamovies.network.models

import com.google.gson.annotations.SerializedName

data class FilmDetailsRequest(
    @SerializedName("poster_path")
    val poster_path: String,
    @SerializedName("budget")
    val budget: Int,
    @SerializedName("genres")
    val genres: List<Genre>,
    @SerializedName("homepage")
    val homepage: String,
    @SerializedName("original_language")
    val originalLanguage: String,
    @SerializedName("original_title")
    val originalTitle: String,
    @SerializedName("overview")
    val overview: String,
    @SerializedName("popularity")
    val popularity: Int,
    @SerializedName("release_date")
    val releaseDate: String,
    @SerializedName("runtime")
    val runtime: Int,
    @SerializedName("adult")
    val adult: Boolean,
    @SerializedName("production_companies")
    val productionCompanies: List<Company>,
    @SerializedName("spoken_languages")
    val spokenLanguages: List<Language>,
    @SerializedName("id")
    val netId: Int
)

data class Genre(
    @SerializedName("name")
    var GenreName: String
)

data class Company(
    @SerializedName("name")
    val name: String
)

data class Language(
    @SerializedName("name")
    val name: String
)