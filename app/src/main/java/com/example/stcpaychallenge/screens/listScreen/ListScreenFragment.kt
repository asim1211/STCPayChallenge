package com.example.stcpaychallenge.screens.listScreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.core.content.ContextCompat
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import com.example.stcpaychallenge.R
import com.example.stcpaychallenge.base.BaseFragment
import com.example.stcpaychallenge.databinding.FragmentListingBinding
import com.example.stcpaychallenge.di.appComponent
import com.example.stcpaychallenge.model.Job
import com.example.stcpaychallenge.model.Results
import com.example.stcpaychallenge.screens.listScreen.adapters.ItemListAdapter
import com.example.stcpaychallenge.screens.listScreen.interfaces.OnItemClicked
import kotlinx.android.synthetic.main.fragment_listing.*
import viewM

class ListScreenFragment: BaseFragment(), OnItemClicked {

    private val viewModel: ListScreenViewModel by viewM {
        appComponent!!.appListViewModel.create(
            ""
        )
    }

    private lateinit var itemListAdapter: ItemListAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentListingBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListRecycler()
        initSearchBar()
        observeData()
    }

    fun observeData() {

        viewModel.viewData.observeHandleProgress(viewLifecycleOwner) {
            if (it is Results.Success) {
                itemListAdapter.submitList(it.data)
                emptyListMessage.visibility = if (it.data.isNullOrEmpty()) View.VISIBLE else View.GONE

            }
        }
    }

    private fun initListRecycler() {
        itemListAdapter = ItemListAdapter(this)
        val itemDecorator = DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL)
        itemDecorator.setDrawable(ContextCompat.getDrawable(requireContext(), R.drawable.drawable_divider_list)!!)
        listingRecycler.addItemDecoration(itemDecorator)
        listingRecycler.adapter = itemListAdapter
    }

    private fun initSearchBar() {

        searchBar.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                viewModel.getJobs(query)
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }
        })
    }

    private fun openCampaign(job: Job) {
        findNavController().navigate(
            ListScreenFragmentDirections.actionListScreenFragmentToDetailsScreenFragment(
                job
            )
        )
    }

    override fun onItemClicked(job: Job) {
        openCampaign(job)
    }
}