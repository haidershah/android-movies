package com.example.movies.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.LivePagedListBuilder
import androidx.paging.PageKeyedDataSource
import androidx.paging.PagedList
import com.example.movies.domain.model.Movie
import com.example.movies.repository.MoviesRepository
import com.example.movies.view.datasource.MovieDataSourceFactory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MoviesViewModel : ViewModel() {

    companion object {
        private const val FIRST_PAGE = 1
        private const val PAGE_SIZE = 20
    }

    private val repository = MoviesRepository()

    val movies: LiveData<PagedList<Movie>>

    init {
        val config = PagedList.Config.Builder()
            .setPageSize(PAGE_SIZE)
            .setEnablePlaceholders(false)
            .build()

        val factory = MovieDataSourceFactory(
            { callback -> loadInitial(callback) },
            { params, callback -> loadAfter(params, callback) })

        movies = LivePagedListBuilder(factory, config)
            .build()
    }

    private fun loadInitial(callback: PageKeyedDataSource.LoadInitialCallback<Int, Movie>) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                val movies = repository.searchFunction("fast", FIRST_PAGE)
                callback.onResult(movies, null, FIRST_PAGE + 1)
            }
        }
    }

    private fun loadAfter(
        params: PageKeyedDataSource.LoadParams<Int>,
        callback: PageKeyedDataSource.LoadCallback<Int, Movie>
    ) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                val movies = repository.searchFunction("fast", params.key)
                callback.onResult(movies, params.key + 1)
            }
        }
    }
}
