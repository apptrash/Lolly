package com.android.academy.lolly

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    companion object {
        const val FRAGMENT_MOVIES_LIST_TAG = "FRAGMENT_MOVIES_LIST_TAG"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupMoviesListFragment(isRecreated = savedInstanceState != null)
    }

    private fun setupMoviesListFragment(isRecreated: Boolean) {
        val fragment = createOrGetMoviesListFragment(isRecreated)
        fragment.setOnMovieSelectedListener(::onMovieSelected)
        if (!isRecreated) {
            supportFragmentManager.beginTransaction()
                .add(R.id.fragment_container, fragment, FRAGMENT_MOVIES_LIST_TAG)
                .commit()
        }
    }

    private fun createOrGetMoviesListFragment(isRecreated: Boolean) = if (isRecreated) {
        supportFragmentManager.findFragmentByTag(FRAGMENT_MOVIES_LIST_TAG) as FragmentMoviesList
    } else {
        FragmentMoviesList.newInstance()
    }

    private fun onMovieSelected() {
        supportFragmentManager.beginTransaction()
            .add(R.id.fragment_container, FragmentMoviesDetails.newInstance())
            .addToBackStack(null)
            .commit()
    }
}