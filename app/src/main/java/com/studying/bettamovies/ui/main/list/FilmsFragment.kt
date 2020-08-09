package com.studying.bettamovies.ui.main.list

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.studying.bettamovies.App
import com.studying.bettamovies.R
import com.studying.bettamovies.ui.main.list.interfaces.OnFilmClickListener
import com.studying.bettamovies.models.ItemMovie
import com.studying.bettamovies.ui.main.list.interfaces.ListPresenter
import com.studying.bettamovies.ui.main.list.interfaces.MyListView
import kotlinx.android.synthetic.main.fragment_films.*
import javax.inject.Inject

class FilmsFragment : Fragment(),
    OnFilmClickListener,
    MyListView {

    private val adapterFilm: FilmsAdapter = FilmsAdapter(this)

    @Inject
    lateinit var presenter: ListPresenter

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (context.applicationContext as App).appComponent.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_films, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        presenter.bind(this@FilmsFragment)
        films_list.adapter = adapterFilm
    }

    override fun onFilmClick(netId: Int) =
        presenter.userSelectedMovie(netId)

    override fun showToast(message: String) =
        Toast.makeText(view?.context, message, Toast.LENGTH_SHORT).show()

    override fun updateUi(moviesList: List<ItemMovie>) =
        adapterFilm.update(moviesList)

    override fun showErrorImage() {
        films_list.visibility = View.INVISIBLE
        error_image.visibility = View.VISIBLE
    }
}