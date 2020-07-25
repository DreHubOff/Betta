package com.studying.bettamovies.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.studying.bettamovies.App
import com.studying.bettamovies.R
import com.studying.bettamovies.ui.main.list.FilmsFragment

class MainActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager
            .beginTransaction()
            .replace(
                R.id.main_container,
                FilmsFragment.getInstance(this)
            )
            .addToBackStack(null)
            .commit()
    }

}
