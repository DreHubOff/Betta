package com.studying.bettamovies.interfaces

import android.content.Context

interface Bindable {
    fun bind(context: Context)
    fun unBind()
}