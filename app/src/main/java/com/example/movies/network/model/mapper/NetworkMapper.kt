package com.example.movies.network.model.mapper

import com.example.movies.domain.model.Movie
import com.example.movies.network.model.NetworkMovie

fun NetworkMovie.asDomainModel(): Movie {
    return Movie(id, title)
}

fun List<NetworkMovie>.asDomainModels(): List<Movie> {
    return map {
        it.asDomainModel()
    }
}
