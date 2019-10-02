package com.example.movies.view.binding

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movies.R
import com.example.movies.domain.model.Movie
import com.example.movies.view.adapter.MoviesAdapter
import org.joda.time.DateTime
import org.joda.time.format.DateTimeFormat

@BindingAdapter("listData")
fun RecyclerView.setListData(movies: List<Movie>?) {
    val adapter = adapter as MoviesAdapter
    adapter.submitList(movies)
}

@BindingAdapter("imageUrl")
fun ImageView.setImageUrl(imageUrl: String) {
    Glide
        .with(context)
        .load(imageUrl)
        .centerCrop()
        .into(this)
}

@BindingAdapter("releaseDate")
fun TextView.setReleaseDate(releaseDate: String) {
    val date = DateTime.parse(
        releaseDate, DateTimeFormat.forPattern("yyyy-MM-dd")
    ).toString(DateTimeFormat.mediumDate())
    text = context.getString(R.string.release_date, date)
}
