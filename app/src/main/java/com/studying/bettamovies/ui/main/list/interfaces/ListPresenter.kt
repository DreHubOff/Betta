package com.studying.bettamovies.ui.main.list.interfaces

import com.studying.bettamovies.interfaces.BindableFragment

interface ListPresenter: BindableFragment {
    fun userSelectedMovie(netId: Int)
}