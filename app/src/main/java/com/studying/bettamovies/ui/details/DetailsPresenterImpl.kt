package com.studying.bettamovies.ui.details

import android.annotation.SuppressLint
import android.view.View
import androidx.fragment.app.Fragment
import com.studying.bettamovies.models.Loader
import com.studying.bettamovies.ui.details.interfaces.DetailsInteractor
import com.studying.bettamovies.ui.details.interfaces.DetailsPresenter
import com.studying.bettamovies.ui.details.interfaces.DetailsView
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import java.util.*
import javax.inject.Inject

class DetailsPresenterImpl @Inject constructor(
    val interactor: DetailsInteractor,
    val disposable: CompositeDisposable
) : DetailsPresenter {
    var view: DetailsView? = null

    @SuppressLint("CheckResult")
    override fun bind(fragment: Fragment) {
        view = fragment as DetailsView

        (fragment as FilmDetailsFragment).idMessage
            .subscribe({

                disposable.add(interactor.getMovieDetails(it)
                    .subscribe({

                    }, {/*Do nothing*/ })

                )
            }, {/*Do nothing*/ })
    }

    override fun unBind() {
        view = null
        disposable.dispose()
        disposable.clear()
    }
}