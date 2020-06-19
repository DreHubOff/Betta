package com.studying.bettamovies

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.studying.bettamovies.interfaces.ActivityNavigation

class MainActivity : AppCompatActivity(),
    ActivityNavigation {


    companion object {
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.main_container, FilmsFragment.newInstance())
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
