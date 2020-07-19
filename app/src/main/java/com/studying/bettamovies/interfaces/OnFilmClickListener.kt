package com.studying.bettamovies.interfaces

import android.view.View

interface OnFilmClickListener {
    fun onFilmClick(filmID: String, posterUI: View)
}