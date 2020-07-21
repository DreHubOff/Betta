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
import com.studying.bettamovies.db.models.MovieEntity
import com.studying.bettamovies.interfaces.OnFilmClickListener
import com.studying.bettamovies.network.models.Movie
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
        presenter.userSeeView()
    }

    override fun onFilmClick(filmID: String, root: View) {
        presenter.userSelectedMovie(filmID, root)
    }

    override fun showDetails(fragmentTransaction: FragmentTransaction?) {
        exitTransition = Fade()
        fragmentTransaction?.commit()
    }

    override fun showToast(message: String) {
        Toast.makeText(view?.context, message, Toast.LENGTH_SHORT).show()
    }

    override fun updateUi(list: List<MovieEntity>) {
        adapterFilm.update(list)
    }

    override fun onStop() {
        super.onStop()
        presenter.disposable.dispose()
    }
}