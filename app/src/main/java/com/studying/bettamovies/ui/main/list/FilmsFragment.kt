package com.studying.bettamovies.ui.main.list

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.transition.Fade
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction
import com.studying.bettamovies.R
import com.studying.bettamovies.data.Repository
import com.studying.bettamovies.db.models.MovieEntity
import com.studying.bettamovies.interfaces.OnFilmClickListener
import com.studying.bettamovies.ui.MainActivity
import kotlinx.android.synthetic.main.fragment_films.*

class FilmsFragment(private val activity: AppCompatActivity) : Fragment(),
    OnFilmClickListener, MyListView {

    private lateinit var adapterFilm: FilmsAdapter
    private lateinit var presenter: ListPresenter

    companion object {
        private var filmsFragment: FilmsFragment? = null
        fun getInstance(activity: AppCompatActivity):FilmsFragment{
            if (filmsFragment == null){
                filmsFragment = FilmsFragment(activity)
            }
            return filmsFragment!!
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        presenter = ListPresenter(activity)
        adapterFilm = FilmsAdapter(this)
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
        presenter.disposable?.dispose()
    }
}