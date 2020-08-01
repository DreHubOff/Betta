package com.studying.bettamovies.ui.main.list

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
import com.studying.bettamovies.App
import com.studying.bettamovies.R
import com.studying.bettamovies.data.MainActivityHolder
import com.studying.bettamovies.db.models.MovieEntity
import com.studying.bettamovies.interfaces.OnFilmClickListener
import com.studying.bettamovies.ui.MainActivity
import kotlinx.android.synthetic.main.fragment_films.*
import javax.inject.Inject

class FilmsFragment() : Fragment(),
    OnFilmClickListener, MyListView {

    private val adapterFilm: FilmsAdapter = FilmsAdapter(this)

    @Inject
    lateinit var presenter: ListPresenter

    @Inject
    lateinit var mainActivity: MainActivityHolder

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (context.applicationContext as App).appComponent.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_films, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        presenter.apply {
            bind(mainActivity.mySingleActivity.applicationContext)
            this.view = this@FilmsFragment
        }

        films_list.adapter = adapterFilm
    }

    override fun onDetach() {
        super.onDetach()
        presenter.unBind()
    }

    override fun onFilmClick(filmID: String) =
        presenter.userSelectedMovie(filmID)

    override fun showToast(message: String) =
        Toast.makeText(view?.context, message, Toast.LENGTH_SHORT).show()

    override fun updateUi(movieList: List<MovieEntity>) =
        adapterFilm.update(movieList)
}