package com.android.y_kawaguchi.search_github_repository_app.repository

import com.android.y_kawaguchi.search_github_repository_app.ApiResult
import com.android.y_kawaguchi.search_github_repository_app.ApiService
import com.android.y_kawaguchi.search_github_repository_app.App
import com.android.y_kawaguchi.search_github_repository_app.repository.model.SearchRepositoriesData

class SearchRepository(private val apiService: ApiService) {

    suspend fun getSearchRepositories(query: String):ApiResult<SearchRepositoriesData>? {

        var apiResult: ApiResult<SearchRepositoriesData>? = null

        runCatching {
            apiService.getSearch(App.ACCEPT, query)
        }.onSuccess {
            apiResult = if (it.isSuccessful) {
                val body = it.body() ?: return ApiResult.Error
                ApiResult.Success(body)
            } else {
                ApiResult.Error
            }
        }.onFailure {
            apiResult = ApiResult.Error
        }
        return apiResult
    }
}
