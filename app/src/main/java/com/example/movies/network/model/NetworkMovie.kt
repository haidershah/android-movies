package com.example.movies.network.model

import com.google.gson.annotations.SerializedName

data class NetworkMovie(

    @SerializedName("id")
    val id: Int,

    @SerializedName("title")
    val title: String,

    @SerializedName("poster_path")
    val imagePath: String,

    @SerializedName("release_date")
    val releaseDate: String
)
