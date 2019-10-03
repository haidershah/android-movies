package com.example.movies.view.datasource

import android.util.Log
import androidx.paging.PageKeyedDataSource
import com.example.movies.domain.model.Movie
import com.example.movies.repository.MoviesRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MovieDataSource : PageKeyedDataSource<Int, Movie>() {

    companion object {
        private const val FIRST_PAGE = 1
    }

    private val repository = MoviesRepository()

    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, Movie>
    ) {
        CoroutineScope(Dispatchers.IO).launch {
            val movies = repository.searchFunction("fast", FIRST_PAGE)
            callback.onResult(movies, null, FIRST_PAGE + 1)
        }

        Log.e("yooooo", "loadInitial: $FIRST_PAGE")
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, Movie>) {
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, Movie>) {
        CoroutineScope(Dispatchers.IO).launch {
            val movies = repository.searchFunction("fast", params.key)
            callback.onResult(movies, params.key + 1)
        }

        Log.e("yooooo", "loadAfter: ${params.key + 1}")
    }
}
