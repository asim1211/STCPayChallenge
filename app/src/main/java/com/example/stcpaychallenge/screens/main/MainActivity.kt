package com.example.stcpaychallenge.screens.main

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
import com.example.stcpaychallenge.R
import com.example.stcpaychallenge.common.ProgressBarInterface
import com.example.stcpaychallenge.di.AppInjector
import com.example.stcpaychallenge.di.AppInjector.appComponent
import kotlinx.android.synthetic.main.activity_main.*
import viewM

class MainActivity : AppCompatActivity(), ProgressBarInterface {

    private val viewModel: MainViewModel by viewM {
        appComponent!!.appMainViewModel.create(
            ""
        )
    }
    private var mainProgressBar: ProgressBar? = null
        set(value) {
            field = value ?: progressBar
        }


    override fun onCreate(savedInstanceState: Bundle?) {

        AppInjector.createVendorsComponent(application)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainProgressBar = progressBar
        navigateToHomeFragment()

    }

    override fun showProgress(show: Boolean) {
        mainProgressBar?.visibility = if (show) View.VISIBLE else View.GONE
    }


    private fun navigateToHomeFragment() {
        val navGraph = getNavGraph()
        navGraph.startDestination = R.id.ListingFragment
        getNavController().graph = navGraph
    }

    override fun onBackPressed() {
        if (!getNavController().popBackStack())
            super.onBackPressed()
    }

    private fun getNavGraph() = getNavController().navInflater.inflate(R.navigation.nav_graph)

    private fun getNavController() = Navigation.findNavController(this, R.id.nav_host_fragment)

}