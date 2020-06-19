package com.studying.bettamovies

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.studying.bettamovies.network.ApiService
import io.reactivex.disposables.Disposable

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FilmDetailsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class FilmDetailsFragment(filmID: String) : Fragment() {

    private lateinit var disposable: Disposable
    private val idFilm = filmID

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
//disposable = ApiService.getMovieById(idFilm.toInt())
    }
}