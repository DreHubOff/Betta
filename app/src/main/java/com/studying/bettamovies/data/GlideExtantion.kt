package com.studying.bettamovies.data

import com.bumptech.glide.Glide
import com.bumptech.glide.GlideBuilder
import com.bumptech.glide.load.engine.cache.InternalCacheDiskCacheFactory
import com.studying.bettamovies.App

fun Glide.init(app: App) {
    val gb = GlideBuilder().apply {
        setDiskCache(
            InternalCacheDiskCacheFactory(
                app,
                "Glide_Cache_BettaMovies",
                1024 * 1024 * 50
            )
        )
    }
    Glide.init(app, gb)
}