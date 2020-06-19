package com.studying.bettamovies

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.studying.bettamovies.interfaces.ActivityNavigation
import com.studying.bettamovies.network.ApiService
import com.studying.bettamovies.network.models.Movie
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class MainActivity : AppCompatActivity(),
    ActivityNavigation {

    private lateinit var disposable: Disposable

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
