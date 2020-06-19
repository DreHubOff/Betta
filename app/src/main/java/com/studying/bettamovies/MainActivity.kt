package com.studying.bettamovies

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.studying.bettamovies.interfaces.ActivityNavigation

class MainActivity : AppCompatActivity(),
    ActivityNavigation {

companion object {
        private adapterFilm = FilmsAdapter()  
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
      
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.main_container, FilmsFragment.newInstance())
            .addToBackStack(null)
            .commit()
   
        disposable = ApiService.getPopularMovies(1)
            .flatMap { firstList ->
                val resList = mutableListOf<Movie>().apply {addAll(firstList.movies)}
                for (i in 2..30){
                    ApiService.getPopularMovies(i)
                        .subscribe({
                            resList.addAll(it.movies)
                        },{
                            it.printStackTrace()
                            Toast.makeText(this, "Some Error", Toast.LENGTH_SHORT).show()
                        })
                }
                Single.just(resList)
            }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ adapterFilm.update(it) }, {
                it.printStackTrace()
                Toast.makeText(this, "Some Error", Toast.LENGTH_SHORT).show()
            })
     
        }
    }

    override fun showFragmentWithCocktailDetails(filmId: String) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.main_container, FilmDetailsFragment.newInstance(filmId))
            .addToBackStack(null)
            .commit()
    }
}
