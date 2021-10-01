package io.github.maylcf.moviesflix.usecase

import io.github.maylcf.moviesflix.data.MovieRepository

class MovieListUseCase(private val movieRepository: MovieRepository) {

    operator fun invoke() = movieRepository.getAllMovieFromDataSource()
}