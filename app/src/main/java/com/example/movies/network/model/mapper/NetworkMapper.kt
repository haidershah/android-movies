package com.example.movies.network.model.mapper

import com.example.movies.domain.model.Movie
import com.example.movies.network.model.NetworkMovie

private const val IMAGE_BASE_URL = "https://image.tmdb.org/t/p/w500/"

fun NetworkMovie.asDomainModel(): Movie {
    return Movie(id, title, IMAGE_BASE_URL + imagePath, releaseDate)
}

fun List<NetworkMovie>.asDomainModels(): List<Movie> {
    return map {
        it.asDomainModel()
    }
}
