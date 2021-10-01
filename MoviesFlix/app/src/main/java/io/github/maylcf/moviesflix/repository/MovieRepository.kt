package io.github.maylcf.moviesflix.repository

import android.util.Log
import io.github.maylcf.moviesflix.api.MovieRestApiTask
import io.github.maylcf.moviesflix.model.Movie

class MovieRepository(private val movieRestApiTask: MovieRestApiTask) {

    companion object {
        const val tag = "MovieRepository"
    }

    private val movieList = arrayListOf<Movie>()

    fun getAllMovies(): List<Movie> {
        val request = movieRestApiTask.retrofitApi().getAllMovies().execute()

        if (request.isSuccessful) {
            request.body()?.let {
                movieList.addAll(it)
            }
        } else {
            request.errorBody()?.let {
                Log.d(tag, it.toString())
            }
        }

        return movieList
    }
}