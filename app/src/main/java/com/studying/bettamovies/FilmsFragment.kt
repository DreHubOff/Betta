package com.studying.bettamovies

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import com.studying.bettamovies.interfaces.ActivityNavigation
import com.studying.bettamovies.interfaces.OnFilmClickListener
import com.studying.bettamovies.network.ApiService
import com.studying.bettamovies.network.models.Movie
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_films.*
import java.lang.IllegalArgumentException

class FilmsFragment : Fragment(),
    OnFilmClickListener {

    lateinit var disposable: Disposable


    companion object {
        val adapterFilm: FilmsAdapter = FilmsAdapter(newInstance())
        fun newInstance() = FilmsFragment()
        private var navigation: ActivityNavigation? = null
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is ActivityNavigation) {
            navigation = context as ActivityNavigation
        } else {
            throw IllegalArgumentException(context::class.java.name + "Error")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_films, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        films_list.apply {
            layoutManager = GridLayoutManager(view.context, 2)
            adapter = adapterFilm
        }

        disposable = ApiService.getPopularMovies(1)
            .flatMap { firstList ->
                val resList = mutableListOf<Movie>().apply { addAll(firstList.movies) }
                for (i in 2..30) {
                    ApiService.getPopularMovies(i)
                        .subscribe({
                            resList.addAll(it.movies)
                        }, {
                            it.printStackTrace()
                            Toast.makeText(view.context, "Some Error", Toast.LENGTH_SHORT).show()
                        })
                }
                Single.just(resList)
            }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ adapterFilm.update(it) }, {
                it.printStackTrace()
                Toast.makeText(view.context, "Some Error", Toast.LENGTH_SHORT).show()
            })
    }

    override fun onFilmClick(filmID: String) {
        navigation?.showFragmentWithCocktailDetails(filmID)
    }
}