package com.studying.bettamovies.ui.details

import android.opengl.Visibility
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.studying.bettamovies.App
import com.studying.bettamovies.data.Repository
import com.studying.bettamovies.models.Loader
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_film_details_fragment.*
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class DetailsPresenter(private val app: App): Loader.OnLoadingStartListener {
    var disposable: Disposable? = null
    var view: DetailsView? = null

    @Inject
    lateinit var repository: Repository

    init {
        app.appComponent.inject(this)
    }

    fun userSeesView(movieId: String, imageView: ImageView) {
        val loader = Loader(this)
            loader.startLoadingDelay(700)

        disposable = repository.getMovieById(movieId)
            .subscribe({
                view?.apply {
                    updateUI(it)
                    loader.unActiveDelay()
                    showLoader(false)
                    changeInfoVisibility(View.VISIBLE)
                }
                repository.updateDataBase(it)
                repository.setupImage(imageView, app, it)
            }, {
                loader.unActiveDelay()
                view?.showLoader(false)
                view?.showToast("Network connection error")
            })

    }

    override fun onLoadingStart() {
        view?.showLoader(true)
    }
}