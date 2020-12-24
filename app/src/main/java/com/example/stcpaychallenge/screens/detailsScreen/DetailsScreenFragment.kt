package com.example.stcpaychallenge.screens.detailsScreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.stcpaychallenge.base.BaseFragment
import com.example.stcpaychallenge.databinding.FragmentDetailsBinding
import com.example.stcpaychallenge.databinding.FragmentListingBinding
import com.example.stcpaychallenge.di.appComponent
import com.example.stcpaychallenge.screens.listScreen.ListScreenViewModel
import viewM

class DetailsScreenFragment: BaseFragment() {

    private val args: DetailsScreenFragmentArgs? by navArgs()
    private val viewModel: ListScreenViewModel by viewM {
        appComponent!!.appListViewModel.create(
            ""
        )

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentDetailsBinding.inflate(inflater)
        binding.job = args?.job
        return binding.root
    }

}