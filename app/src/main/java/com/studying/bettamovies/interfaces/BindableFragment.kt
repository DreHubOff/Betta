package com.studying.bettamovies.interfaces

import androidx.fragment.app.Fragment

interface BindableFragment: Bindable {
    fun bind(fragment: Fragment)
}