package com.example.movies.network.model

import com.google.gson.annotations.SerializedName

data class NetworkResult(
    @SerializedName("results")
    val movies: List<NetworkMovie>
)
