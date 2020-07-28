package com.studying.bettamovies.ui.details

import com.studying.bettamovies.db.models.MovieEntity

interface DetailsView {
    fun showToast(message: String)
    fun updateUI(movieEntity: MovieEntity?)
    fun changeInfoVisibility(state: Int)
    fun showLoader(flag: Boolean)
}