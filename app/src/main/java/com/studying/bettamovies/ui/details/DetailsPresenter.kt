package com.studying.bettamovies.ui.details

import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.studying.bettamovies.App
import com.studying.bettamovies.data.Repository
import io.reactivex.disposables.Disposable
import kotlinx.android.synthetic.main.fragment_film_details_fragment.*
import javax.inject.Inject

class DetailsPresenter(private val activity: AppCompatActivity) {
    var disposable: Disposable? = null
    var view: DetailsView? = null

    @Inject
    lateinit var repository: Repository

    init {
        (activity.applicationContext as App).appComponent.inject(this)
    }

    fun userSeesView(movieId: String, imageView: ImageView) {
        disposable = repository.getMovieById(movieId)
            .subscribe({
                view?.updateUI(it)
                repository.updateDataBase(it)
                repository.setupImage(imageView, activity.applicationContext, it)
            },{
                view?.showToast("Network connection error")
            })

    }
}