package com.android.y_kawaguchi.search_github_repository_app.ui.search

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.y_kawaguchi.search_github_repository_app.ApiResult
import com.android.y_kawaguchi.search_github_repository_app.repository.SearchRepository
import com.android.y_kawaguchi.search_github_repository_app.repository.model.SearchRepositoriesData
import kotlinx.coroutines.launch

class SearchViewModel(private val searchRepository: SearchRepository) : ViewModel() {

    private var searchRepositories: SearchRepositoriesData? = null
    private var navigation: SearchNavigation? = null
    val isLoading = MutableLiveData(false)
    val hasItems = MutableLiveData(false)

    fun setNavigation(navigation: SearchNavigation) {
        this.navigation = navigation
    }

    fun getRepositories(query: String) {
        isLoading.value = true
        viewModelScope.launch {
            when (val apiResult = searchRepository.getSearchRepositories(query)) {
                is ApiResult.Success -> {
                    searchRepositories = apiResult.value
                    searchRepositories?.items?.let {
                        navigation?.updateList(it)
                    }
                    isLoading.value = false
                    hasItems.value = searchRepositories?.items.isNullOrEmpty()
                }
                is ApiResult.Error -> {
                    navigation?.showErrorToast()
                    isLoading.value = false
                }
            }
        }
    }
}
