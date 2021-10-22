package com.android.y_kawaguchi.search_github_repository_app.network

import retrofit2.Retrofit

class ApiGenerator(val builder: Retrofit.Builder) {

    fun <T> api(clazz: Class<T>): T =
        builder.baseUrl("https://api.github.com/").build().create(clazz)

}
