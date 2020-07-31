package com.studying.bettamovies.ui.main.list

import android.os.Bundle
import android.transition.Fade
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.FragmentTransaction
import com.studying.bettamovies.App
import com.studying.bettamovies.R
import com.studying.bettamovies.db.models.MovieEntity
import com.studying.bettamovies.interfaces.OnFilmClickListener
import kotlinx.android.synthetic.main.fragment_films.*
import javax.inject.Inject

class FilmsFragment(app: App) : Fragment(),
    OnFilmClickListener, MyListView{

    private val adapterFilm: FilmsAdapter = FilmsAdapter(this)

    @Inject
    lateinit var presenter: ListPresenter

    init {
        app.appComponent.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_films, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        presenter.view = this

        films_list.adapter = adapterFilm
        presenter.userSeesView()
    }

    override fun onFilmClick(filmID: String) =
        presenter.userSelectedMovie(filmID, this)

    override fun showToast(message: String) =
        Toast.makeText(view?.context, message, Toast.LENGTH_SHORT).show()

    override fun updateUi(list: List<MovieEntity>) =
        adapterFilm.update(list)
}