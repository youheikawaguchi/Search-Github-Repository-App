package com.android.y_kawaguchi.search_github_repository_app

import android.util.Log
import retrofit2.Response
import java.lang.Exception
import java.net.SocketTimeoutException

sealed class ApiResult<out T> {
    data class Success<out T>(val value: T) : ApiResult<T>()

    object Error : ApiResult<Nothing>()
}