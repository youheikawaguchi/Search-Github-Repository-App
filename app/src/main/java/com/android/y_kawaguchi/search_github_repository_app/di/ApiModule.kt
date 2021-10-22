package com.android.y_kawaguchi.search_github_repository_app.di

import com.android.y_kawaguchi.search_github_repository_app.ApiService
import com.android.y_kawaguchi.search_github_repository_app.network.ApiGenerator
import org.koin.dsl.module

object ApiModule {
    fun module() = module {
        single {
            get<ApiGenerator>().api(ApiService::class.java)
        }
    }
}
