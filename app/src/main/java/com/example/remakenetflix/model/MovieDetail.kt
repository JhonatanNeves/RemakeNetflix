package com.example.remakenetflix.model

data class MovieDetail(
    val movie: Movie,
    val similars: List<Movie>
)