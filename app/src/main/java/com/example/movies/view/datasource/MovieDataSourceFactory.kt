package com.example.movies.view.datasource

import androidx.paging.DataSource
import androidx.paging.PageKeyedDataSource
import com.example.movies.domain.model.Movie

class MovieDataSourceFactory(
    private val onLoadInitial: (callback: PageKeyedDataSource.LoadInitialCallback<Int, Movie>) -> Unit,
    private val onLoadAfter: (params: PageKeyedDataSource.LoadParams<Int>, callback: PageKeyedDataSource.LoadCallback<Int, Movie>) -> Unit
) : DataSource.Factory<Int, Movie>() {

    override fun create(): DataSource<Int, Movie> {
        return MovieDataSource(onLoadInitial, onLoadAfter)
    }
}
