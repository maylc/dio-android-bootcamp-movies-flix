package io.github.maylcf.moviesflix.implementation

import android.util.Log
import io.github.maylcf.moviesflix.api.MovieRestApiTask
import io.github.maylcf.moviesflix.data.MovieDataSource
import io.github.maylcf.moviesflix.domain.Movie

class MovieDataSourceImplementation(private val movieRestApiTask: MovieRestApiTask) :
    MovieDataSource {

    companion object {
        const val tag = "MovieRepository"
    }

    private val movieList = arrayListOf<Movie>()

    override fun getAllMovies(): List<Movie> {
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