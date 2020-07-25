package com.studying.bettamovies.ui.details

import androidx.appcompat.app.AppCompatActivity
import com.studying.bettamovies.App
import io.reactivex.disposables.Disposable
import kotlinx.android.synthetic.main.fragment_film_details_fragment.*

class DetailsPresenter(private val activity: AppCompatActivity) {
    var disposable: Disposable? = null
    var view: DetailsView? = null
    private val repository = (activity.application as App).repository

    fun userSeesView(movieId: String) {
        disposable = repository.getMovieById(movieId)
            .subscribe({
                view?.updateUI(it)
                repository.updateDataBase(it)
                repository.setupImage(activity.background_logo, activity.applicationContext, it)
            },{
                view?.showToast("Network connection error")
            })

    }
}