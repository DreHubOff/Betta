package com.studying.bettamovies.ui.details

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.studying.bettamovies.App
import com.studying.bettamovies.R
import com.studying.bettamovies.databinding.FragmentFilmDetailsFragmentBinding
import com.studying.bettamovies.db.models.MovieItemEntity
import com.studying.bettamovies.ui.details.interfaces.DetailsPresenter
import com.studying.bettamovies.ui.details.interfaces.DetailsView
import io.reactivex.Single
import io.reactivex.disposables.Disposable
import kotlinx.android.synthetic.main.fragment_film_details_fragment.*
import javax.inject.Inject

class FilmDetailsFragment : Fragment(),
    DetailsView {

    @Inject
    lateinit var presenter: DetailsPresenter

    lateinit var binding: FragmentFilmDetailsFragmentBinding
    lateinit var idMessage: Single<Int>

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (context.applicationContext as App).appComponent.inject(this)
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
        presenter.bind(this)
        idMessage.subscribe({
            //   presenter.userSeesView(it, view.background_logo)
        }, {/*Do nothing*/ })
    }


    override fun showToast(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show()
    }

    override fun updateUI(movieItemEntity: MovieItemEntity?) {
        // binding.movie = movieItemEntity

//        if (validateInputData(movieItemEntity?.homepage) != "no information") {
//            txt_details_homepage.setTextColor(resources.getColor(R.color.blue_light))
//            txt_details_homepage.setOnClickListener {
//                val intent = Intent(
//                    Intent.ACTION_VIEW,
//                    Uri.parse(validateInputData(movieItemEntity?.homepage))
//                )
//                startActivity(intent)
//            }
//        } else {
//            txt_details_homepage.setTextColor(resources.getColor(R.color.green_light))
//        }
    }


    override fun changeInfoVisibility(state: Int) {
        info_scroll.visibility = state
    }

    override fun showLoader(flag: Boolean) {
        when (flag) {
            true -> {
                loader_anim.visibility = View.VISIBLE
                loader_anim.playAnimation()
            }
            false -> {
                loader_anim.visibility = View.GONE
                loader_anim.pauseAnimation()
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.unBind()
    }
}