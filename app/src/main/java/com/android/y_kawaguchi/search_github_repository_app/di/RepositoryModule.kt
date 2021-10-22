package com.android.y_kawaguchi.search_github_repository_app.di

import com.android.y_kawaguchi.search_github_repository_app.repository.SearchRepository
import org.koin.dsl.module

object RepositoryModule {
    fun module() = module {
        single {
            SearchRepository(get())
        }
    }
}
