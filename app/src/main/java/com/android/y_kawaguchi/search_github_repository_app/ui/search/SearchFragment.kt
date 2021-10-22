package com.android.y_kawaguchi.search_github_repository_app.ui.search

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.y_kawaguchi.search_github_repository_app.databinding.SearchFragmentBinding
import com.android.y_kawaguchi.search_github_repository_app.repository.model.SearchRepositoryItemData
import org.koin.androidx.viewmodel.ext.android.viewModel

interface SearchNavigation {
    fun updateList(list: List<SearchRepositoryItemData>)
    fun showErrorToast()
}

class SearchFragment : Fragment(), SearchNavigation {

    companion object {
        fun newInstance() = SearchFragment()
    }

    private val viewModel: SearchViewModel by viewModel()
    private lateinit var mAdapter: SearchListAdapter
    private var binding: SearchFragmentBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val currentBinding =
            SearchFragmentBinding.inflate(inflater, container, false).also {
                this.binding = it
            }

        with(currentBinding) {
            viewModel = this@SearchFragment.viewModel
            lifecycleOwner = this@SearchFragment
            setupSearchView(searchView)
            setupRecyclerView(recyclerView)
        }

        viewModel.setNavigation(this)

        return currentBinding.root
    }

    private fun setupRecyclerView(recyclerView: RecyclerView) {
        with(recyclerView) {
            adapter = SearchListAdapter().also { mAdapter = it }
            layoutManager = LinearLayoutManager(context)
        }
    }

    private fun setupSearchView(searchView: SearchView) {
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                if (!query.isNullOrBlank()) {
                    viewModel.getRepositories(query)
                }
                return true
            }

            override fun onQueryTextChange(p0: String?): Boolean {
                return true
            }
        })
    }

    override fun updateList(list: List<SearchRepositoryItemData>) {
        mAdapter.submitList(list)
    }

    override fun showErrorToast() {
        Toast.makeText(context, "読み込みに失敗しました", Toast.LENGTH_SHORT).show()
    }
}
