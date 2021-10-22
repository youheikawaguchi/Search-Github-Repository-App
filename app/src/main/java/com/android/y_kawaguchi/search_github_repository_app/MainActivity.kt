package com.android.y_kawaguchi.search_github_repository_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.android.y_kawaguchi.search_github_repository_app.ui.search.SearchFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, SearchFragment.newInstance())
                .commitNow()
        }
    }
}