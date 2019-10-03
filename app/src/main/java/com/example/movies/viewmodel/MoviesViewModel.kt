package com.example.movies.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.example.movies.domain.model.Movie
import com.example.movies.view.datasource.MovieDataSourceFactory

class MoviesViewModel : ViewModel() {

    companion object {
        const val PAGE_SIZE = 20
    }

    val movies: LiveData<PagedList<Movie>>

    init {
        val config = PagedList.Config.Builder()
            .setPageSize(PAGE_SIZE)
            .setEnablePlaceholders(false)
            .build()

        val factory = MovieDataSourceFactory()

        movies = LivePagedListBuilder(factory, config)
            .build()
    }
}
