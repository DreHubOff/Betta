package com.studying.bettamovies.ui.details

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.studying.bettamovies.R
import com.studying.bettamovies.data.validateInputData
import com.studying.bettamovies.databinding.FragmentFilmDetailsFragmentBinding
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
    lateinit var binding: FragmentFilmDetailsFragmentBinding

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
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_film_details_fragment,
            container,
            false
        )
        return binding.root
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
        binding.movie = movieEntity
        txt_details_homepage.setOnClickListener {
            if (validateInputData(movieEntity?.homepage) != "no information") {
                val intent = Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse(validateInputData(movieEntity?.homepage))
                )
                txt_details_homepage.setTextColor(resources.getColor(R.color.blue_light))
                startActivity(intent)
            } else {
                txt_details_homepage.setTextColor(resources.getColor(R.color.green_light))
            }
        }
    }
}