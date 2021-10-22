package com.android.y_kawaguchi.search_github_repository_app

import com.android.y_kawaguchi.search_github_repository_app.repository.model.SearchRepositoriesData
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface ApiService {

    @GET("search/repositories")
    suspend fun getSearch(
        @Header("accept") authorization: String,
        @Query("q") query: String
    ): Response<SearchRepositoriesData>

}
