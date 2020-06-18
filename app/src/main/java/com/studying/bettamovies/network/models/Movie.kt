package com.studying.bettamovies.network.models

import com.google.gson.annotations.SerializedName

data class Movie(
    @SerializedName("popularity")
    val popularity: Double,
    @SerializedName("poster_path")
    val image: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("original_title")
    val name: String,
    @SerializedName("original_language")
    val language: String
)
