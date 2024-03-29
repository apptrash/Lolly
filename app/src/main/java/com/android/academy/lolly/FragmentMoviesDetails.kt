package com.android.academy.lolly

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

typealias OnMovieSelectedListener = () -> Unit

class FragmentMoviesDetails : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_movies_details, container, false)

    companion object {
        fun newInstance() = FragmentMoviesDetails()
    }
}
