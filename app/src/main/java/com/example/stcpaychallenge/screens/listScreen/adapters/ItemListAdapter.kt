package com.example.stcpaychallenge.screens.listScreen.adapters
import androidx.databinding.library.baseAdapters.BR

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.stcpaychallenge.R
import com.example.stcpaychallenge.model.Job
import com.example.stcpaychallenge.screens.listScreen.interfaces.OnItemClicked


internal class ItemListAdapter(
    private val onItemClicked: OnItemClicked
) : ListAdapter<Job, ListViewHolder>(ListItemDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<ViewDataBinding>(layoutInflater, viewType, parent, false)
        return ListViewHolder(binding, onItemClicked)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) = holder.bind(getItem(position))
    override fun getItemViewType(position: Int) = R.layout.list_item_layout

    override fun getItemCount(): Int {
        return currentList.size
    }
}

class ListItemDiffCallback : DiffUtil.ItemCallback<Job>() {
    override fun areItemsTheSame(oldItem: Job, newItem: Job): Boolean = oldItem == newItem
    override fun areContentsTheSame(oldItem: Job, newItem: Job): Boolean = oldItem == newItem
}

internal class ListViewHolder(
    private val binding: ViewDataBinding,
    private val onItemClicked: OnItemClicked
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(job: Job) {
        binding.setVariable(BR.job, job)
        binding.executePendingBindings()
        itemView.setOnClickListener { onItemClicked.onItemClicked(job)}
    }
}