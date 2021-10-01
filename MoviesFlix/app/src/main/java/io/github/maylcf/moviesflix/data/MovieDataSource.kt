package io.github.maylcf.moviesflix.data

import io.github.maylcf.moviesflix.domain.Movie

interface MovieDataSource {
    fun getAllMovies(): List<Movie>
}