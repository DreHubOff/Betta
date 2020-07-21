package com.studying.bettamovies.ui.main.list

import androidx.fragment.app.FragmentTransaction
import com.studying.bettamovies.db.models.MovieEntity

interface MyListView {
    fun showDetails(fragmentTransaction: FragmentTransaction?)
    fun showToast(message: String)
    fun updateUi(movieList: List<MovieEntity>)
}