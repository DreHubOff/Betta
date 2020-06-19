package com.studying.bettamovies

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.studying.bettamovies.network.ApiService
import com.studying.bettamovies.network.models.Movie
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),OnFilmClickListener {

    lateinit var disposable: Disposable

    companion object {
        val adapterFilm:FilmsAdapter = FilmsAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        films_list.apply {
            layoutManager = GridLayoutManager(this@MainActivity,2)
            adapter = adapterFilm
        }

        disposable = ApiService.getPopularMovies(1)
            .flatMap { firstList ->
                val resList = mutableListOf<Movie>().apply {addAll(firstList.movies)}
                for (i in 2..30){
                    ApiService.getPopularMovies(i)
                        .subscribe({
                            resList.addAll(it.movies)
                        },{
                            it.printStackTrace()
                            Toast.makeText(this, "Some Error", Toast.LENGTH_SHORT).show()
                        })
                }
                Single.just(resList)
            }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ adapterFilm.update(it) }, {
                it.printStackTrace()
                Toast.makeText(this, "Some Error", Toast.LENGTH_SHORT).show()
            })
        films_list.apply {
            layoutManager = GridLayoutManager(this.context, 2)
            adapter = adapterFilm
        }
    }

    override fun onFilmClick(filmID: String) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.films_list,FilmDetailsFragment.newInstance(filmID))
            .addToBackStack(null)
            .commit()
    }
}
