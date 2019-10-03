package com.example.movies.view.datasource

import androidx.paging.PageKeyedDataSource
import com.example.movies.domain.model.Movie

class MovieDataSource(
    private val onLoadInitial: (callback: LoadInitialCallback<Int, Movie>) -> Unit,
    private val onLoadAfter: (params: LoadParams<Int>, callback: LoadCallback<Int, Movie>) -> Unit
) : PageKeyedDataSource<Int, Movie>() {

    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, Movie>
    ) {
        onLoadInitial(callback)
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, Movie>) {
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, Movie>) {
        onLoadAfter(params, callback)
    }
}
