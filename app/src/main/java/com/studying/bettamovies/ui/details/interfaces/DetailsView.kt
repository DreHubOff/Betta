package com.studying.bettamovies.ui.details.interfaces

import com.studying.bettamovies.db.models.MovieItemEntity

interface DetailsView {
    fun showToast(message: String)
    fun updateUI(movieItemEntity: MovieItemEntity?)
    fun changeInfoVisibility(state: Int)
    fun showLoader(flag: Boolean)
}