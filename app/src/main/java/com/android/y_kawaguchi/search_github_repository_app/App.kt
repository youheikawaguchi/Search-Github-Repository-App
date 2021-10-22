package com.android.y_kawaguchi.search_github_repository_app

import android.app.Application
import com.android.y_kawaguchi.search_github_repository_app.di.ApiModule
import com.android.y_kawaguchi.search_github_repository_app.di.NetworkModule
import com.android.y_kawaguchi.search_github_repository_app.di.RepositoryModule
import com.android.y_kawaguchi.search_github_repository_app.di.ViewModelModule
import org.koin.core.context.startKoin

class App : Application() {

    companion object {
        const val ACCEPT = "application/vnd.github.mercy-preview+json"
    }

    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(
                listOf(
                    NetworkModule.module(),
                    ApiModule.module(),
                    RepositoryModule.module(),
                    ViewModelModule.module()
                )
            )
        }
    }
}
