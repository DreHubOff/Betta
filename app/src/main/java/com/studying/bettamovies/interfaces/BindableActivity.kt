package com.studying.bettamovies.interfaces
import androidx.appcompat.app.AppCompatActivity

interface BindableActivity:Bindable {
    fun bind(activity: AppCompatActivity)
}