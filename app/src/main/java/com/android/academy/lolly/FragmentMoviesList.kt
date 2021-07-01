package com.android.academy.lolly

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.card.MaterialCardView

class FragmentMoviesList : Fragment() {
    private var onMovieSelectedListener: OnMovieSelectedListener? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_movies_list, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val movieCard = view.findViewById<MaterialCardView>(R.id.movie_stub_card)
        movieCard.setOnClickListener {
            onMovieSelectedListener?.invoke()
        }
    }

    fun setOnMovieSelectedListener(listener: OnMovieSelectedListener) {
        onMovieSelectedListener = listener
    }

    companion object {
        fun newInstance() = FragmentMoviesList()
    }
}
