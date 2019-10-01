package com.example.movies.network

import com.example.movies.network.model.NetworkMovie
import com.example.movies.network.model.NetworkResult
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

private const val BASE_URL = "https://api.themoviedb.org/3/"

private val retrofit = Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

interface MoviesService {

    @GET("search/movie")
    suspend fun searchMovies(
        @Query("api_key") apiKey: String,
        @Query("query") query: String
    ): NetworkResult
}

object MoviesApi {
    val RETROFIT_SERVICE: MoviesService by lazy {
        retrofit.create(MoviesService::class.java)
    }
}
