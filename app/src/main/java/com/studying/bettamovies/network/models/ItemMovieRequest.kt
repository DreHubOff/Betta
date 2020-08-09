package com.studying.bettamovies.network.models

import com.google.gson.annotations.SerializedName

data class ItemMovieRequest(
    @SerializedName("title")
    val title: String,
    @SerializedName("poster_path")
    val posterURL: String,
    @SerializedName("id")
    val netId: String
)
