package com.studying.bettamovies.models

import android.net.Uri

data class ItemMovie(
    val title: String,
    val posterURL: Uri,
    val netId: Int
)