package com.example.movies.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.movies.R
import com.example.movies.databinding.FragmentMoviesBinding
import com.example.movies.view.adapter.MoviesAdapter
import com.example.movies.viewmodel.MoviesViewModel

class MoviesFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentMoviesBinding>(
            inflater, R.layout.fragment_movies, container, false
        )

        val viewModel = ViewModelProviders.of(this)
            .get(MoviesViewModel::class.java)

        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        binding.moviesRecyclerView.adapter = MoviesAdapter()

        return binding.root
    }
}
