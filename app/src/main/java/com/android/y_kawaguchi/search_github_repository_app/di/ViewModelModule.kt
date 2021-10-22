package com.android.y_kawaguchi.search_github_repository_app.di

import com.android.y_kawaguchi.search_github_repository_app.ui.search.SearchViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object ViewModelModule {
    fun module() = module {
        viewModel { SearchViewModel(get()) }
    }
}
