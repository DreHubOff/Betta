package com.studying.bettamovies.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.studying.bettamovies.App
import com.studying.bettamovies.R
import com.studying.bettamovies.ui.main.list.FilmsFragment
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var filmsFragment: FilmsFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        (applicationContext as App).appComponent.inject(this)

        supportFragmentManager
            .beginTransaction()
            .replace(
                R.id.main_container,
                filmsFragment
            )
            .addToBackStack(null)
            .commit()
    }

    override fun onBackPressed() {
        if (filmsFragment.isResumed)
            finish()
        else super.onBackPressed()
    }
}
