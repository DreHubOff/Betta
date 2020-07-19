package com.studying.bettamovies.ui.main.list

import android.content.Context
import android.os.Bundle
import android.transition.Fade
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.FragmentTransaction
import com.studying.bettamovies.ui.main.list.data.FilmsAdapter
import com.studying.bettamovies.R
import com.studying.bettamovies.interfaces.OnFilmClickListener
import com.studying.bettamovies.model.DataBase
import com.studying.bettamovies.network.ApiService
import com.studying.bettamovies.network.models.Movie
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_films.*

class FilmsFragment : Fragment(),
    OnFilmClickListener, MyListView {

    private lateinit var adapterFilm: FilmsAdapter

    private val presenter = ListPresenter()

    companion object {
        fun newInstance() = FilmsFragment()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        adapterFilm = FilmsAdapter(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_films, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        presenter.view = this
        presenter.activity = activity!!

        films_list.adapter = adapterFilm

        if (DataBase.generalList.isEmpty()) {
            presenter.disposable = ApiService.getPopularMovies(1)
                .flatMap { firstList ->
                    val resList = mutableListOf<Movie>().apply { addAll(firstList.movies) }
                    for (i in 2..10) {
                        ApiService.getPopularMovies(i)
                            .subscribe({
                                resList.addAll(it.movies)
                            }, {
                                it.printStackTrace()
                                Toast.makeText(view.context, "Some Error", Toast.LENGTH_SHORT)
                                    .show()
                            })
                    }
                    Single.just(resList)
                }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    adapterFilm.update(it)
                    DataBase.generalList.apply {
                        clear()
                        addAll(it)
                    }
                }, {
                    it.printStackTrace()
                    Toast.makeText(view.context, "Some Error", Toast.LENGTH_SHORT).show()
                })
        } else {
            adapterFilm.update(DataBase.generalList)
        }

    }

    override fun onFilmClick(filmID: String, root: View) {
        presenter.userSelectedMovie(filmID, root)
    }

    override fun showDetails(fragmentTransaction: FragmentTransaction?) {
        exitTransition = Fade()
        fragmentTransaction?.commit()
    }

    override fun onStop() {
        super.onStop()
        presenter.disposable.dispose()
    }
}