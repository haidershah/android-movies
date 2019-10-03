package com.example.movies.view.datasource

import androidx.paging.DataSource
import com.example.movies.domain.model.Movie

class MovieDataSourceFactory : DataSource.Factory<Int, Movie>() {

    override fun create(): DataSource<Int, Movie> {
        val dataSource = MovieDataSource()
        return dataSource
    }
}
