package com.studying.bettamovies.ui.details

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.studying.bettamovies.R
import com.studying.bettamovies.db.models.MovieEntity
import com.studying.bettamovies.network.ApiService
import com.studying.bettamovies.network.models.FilmDetails
import com.studying.bettamovies.ui.MainActivity
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_film_details_fragment.*
import kotlinx.android.synthetic.main.fragment_film_details_fragment.view.*
import kotlinx.coroutines.*

class FilmDetailsFragment(private val activity: AppCompatActivity) : Fragment(), DetailsView {

    private lateinit var filmId: String
    private lateinit var presenter: DetailsPresenter

    companion object {
        private var filmDetailsFragment: FilmDetailsFragment? = null
        fun getInstance(activity: AppCompatActivity, filmId: String): FilmDetailsFragment {
            if (filmDetailsFragment == null) {
                filmDetailsFragment = FilmDetailsFragment(activity)
            }
            return filmDetailsFragment!!.apply { this.filmId = filmId }
        }

    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        presenter = DetailsPresenter(activity)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_film_details_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        presenter.view = this
        presenter.userSeesView(this.filmId, view.background_logo)
    }

    override fun onStop() {
        super.onStop()
        presenter.disposable?.dispose()
    }

    override fun showToast(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show()
    }

    override fun updateUI(movieEntity: MovieEntity?) {

        txt_details_release_date.text = movieEntity?.releaseDate
        val runtimeStr = movieEntity?.runtime.toString()
        txt_details_runtime.text = if (runtimeStr.isEmpty()) {
            "no information"
        } else {
            "$runtimeStr min"
        }
        txt_details_genres.text = movieEntity?.genres.orEmpty().ifEmpty { "no information" }
        txt_details_overview.text = movieEntity?.overview.orEmpty().ifEmpty { "no information" }
        val budgetStr = movieEntity?.budget.toString()
        txt_details_budget.text = if (budgetStr.isEmpty() || budgetStr == "0") {
            "no information"
        } else {
            "$budgetStr$"
        }
        txt_details_budget.text = "Budget: ${movieEntity?.budget}"
        txt_details_homepage.text = "Homepage:\n\t${movieEntity?.homepage}"
        txt_details_original_language.text = "Original language: ${movieEntity?.language}"
    }
}