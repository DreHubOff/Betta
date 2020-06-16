package com.studying.bettamovies.network.models

import com.google.gson.annotations.SerializedName

data class RequestModel(
    @SerializedName("total_results")
    val total_results: Int,
    @SerializedName("results")
    val movies: List<Movie>
)