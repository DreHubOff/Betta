package com.studying.bettamovies.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.studying.bettamovies.App
import com.studying.bettamovies.R
import javax.inject.Inject

class MainActivity : AppCompatActivity(), MainView{

    @Inject
    lateinit var presenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        (applicationContext as App).appComponent.inject(this)
        presenter.bind(this)
    }

    override fun onBackPressed() {
        presenter.backWasPressed()
        super.onBackPressed()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.unBind()
    }
}
