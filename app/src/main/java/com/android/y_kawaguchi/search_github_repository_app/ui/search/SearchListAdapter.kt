package com.android.y_kawaguchi.search_github_repository_app.ui.search

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.y_kawaguchi.search_github_repository_app.databinding.SearchItemListBinding
import com.android.y_kawaguchi.search_github_repository_app.repository.model.SearchRepositoryItemData

class SearchListAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    class ItemBindingViewHolder(
        val binding: SearchItemListBinding
    ) : RecyclerView.ViewHolder(binding.root)

    private var currentList = listOf<SearchRepositoryItemData>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding = SearchItemListBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ItemBindingViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder !is ItemBindingViewHolder) return
        val item = this.currentList[position]
        with(holder.binding) {
            data = item
        }
    }

    override fun getItemCount() = currentList.size

    fun submitList(list: List<SearchRepositoryItemData>) {
        this.currentList = list
        notifyDataSetChanged()
    }
}
