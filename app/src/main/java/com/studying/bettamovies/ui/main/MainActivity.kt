package com.studying.bettamovies.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.studying.bettamovies.R
import com.studying.bettamovies.interfaces.ActivityNavigation
import com.studying.bettamovies.ui.details.FilmDetailsFragment
import com.studying.bettamovies.ui.main.list.FilmsFragment
import io.reactivex.disposables.Disposable

class MainActivity : AppCompatActivity(),
    ActivityNavigation {

    private lateinit var disposable: Disposable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager
            .beginTransaction()
            .replace(
                R.id.main_container,
                FilmsFragment.newInstance()
            )
            .addToBackStack(null)
            .commit()
    }


    override fun showFragmentWithCocktailDetails(filmId: String) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.main_container, FilmDetailsFragment.newInstance(filmId))
            .addToBackStack(null)
            .commit()
    }

}
