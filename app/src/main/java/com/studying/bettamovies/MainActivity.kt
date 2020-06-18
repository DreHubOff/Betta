package com.studying.bettamovies

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.studying.bettamovies.network.ApiService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var disposable: Disposable

    companion object {
        val adapterFilm = FilmsAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        disposable = ApiService.getPopularMovies()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ adapterFilm.update(it.movies) }, {
                it.printStackTrace()
                Toast.makeText(this, "Some Error", Toast.LENGTH_SHORT).show()
            })
        films_list.apply {
            layoutManager = GridLayoutManager(this.context, 2)
            adapter = adapterFilm
        }
    }
}
