package com.studying.bettamovies.ui.main.list.interfaces

import com.studying.bettamovies.models.ItemMovie

interface MyListView {
    fun showToast(message: String)
    fun updateUi(moviesList: List<ItemMovie>)
    fun showErrorImage()
}