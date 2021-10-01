package io.github.maylcf.moviesflix.data

class MovieRepository(private val movieDataSource: MovieDataSource) {

    fun getAllMovieFromDataSource() = movieDataSource.getAllMovies()
}