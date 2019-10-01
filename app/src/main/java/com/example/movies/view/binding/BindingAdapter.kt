package com.example.movies.view.binding

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.movies.domain.model.Movie
import com.example.movies.view.adapter.MoviesAdapter

@BindingAdapter("listData")
fun RecyclerView.setListData(movies: List<Movie>?) {
    val adapter = adapter as MoviesAdapter
    adapter.submitList(movies)
}
