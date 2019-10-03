package com.example.movies.repository

import com.example.movies.domain.model.Movie
import com.example.movies.network.MoviesApi
import com.example.movies.network.model.mapper.asDomainModels

private const val API_KEY = "61aeba9b75b70aa856142c608e5bc6f2"

class MoviesRepository {

    suspend fun searchFunction(query: String, page: Int): List<Movie> {
        return MoviesApi.RETROFIT_SERVICE.searchMovies(API_KEY, query, page)
            .movies
            .asDomainModels()
    }
}
