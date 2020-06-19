package com.studying.bettamovies

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.studying.bettamovies.network.ApiService
import com.studying.bettamovies.network.models.FilmDetails
import io.reactivex.Single.just
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_film_details_fragment.*

class FilmDetailsFragment(private val filmID: String) : Fragment() {

    private lateinit var disposable: Disposable

    companion object {
        fun newInstance(filmID: String) =
            FilmDetailsFragment(filmID)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {


        return inflater.inflate(R.layout.fragment_film_details_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        disposable = ApiService.getDetailsById(filmID.toInt())
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                updateUi(it)
                Glide.with(view.context)
                    .load(ApiService.getImageUrl(it.backdropImageURL))
                    .into(background_logo)
            }, {
                it.printStackTrace()
                Toast.makeText(view.context, "Some Error", Toast.LENGTH_SHORT).show()
            })

    }

    @SuppressLint("SetTextI18n")
    private fun updateUi(filmDetails: FilmDetails) {
        txt_details_release_date.text = "Release date: ${filmDetails.releaseDate}"
        txt_details_runtime.text = "Runtime: ${filmDetails.runtime} min"
        txt_details_genres.text = "Genres: ${filmDetails.genres.joinToString {it.GenreName}}"
        txt_details_rate.text = "Vote count: ${filmDetails.voteCount}"
        txt_details_overview.text = "Overview: ${filmDetails.overview}"
        txt_details_budget.text = "Budget: ${filmDetails.budget}"
        txt_details_homepage.text = "Homepage: ${filmDetails.homepage}"
        txt_details_original_language.text = "Original language: ${filmDetails.originalLanguage}"
    }
}