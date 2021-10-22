package com.android.y_kawaguchi.search_github_repository_app.repository.model

import java.io.Serializable

data class SearchRepositoriesData(
    val totalCount: Int,
    val items: List<SearchRepositoryItemData>
) : Serializable

data class SearchRepositoryItemData(
    val id: Int,
    val name: String
) : Serializable
