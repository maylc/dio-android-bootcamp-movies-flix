package io.github.maylcf.moviesflix.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.github.maylcf.moviesflix.api.MovieRestApiTask
import io.github.maylcf.moviesflix.model.Movie
import io.github.maylcf.moviesflix.repository.MovieRepository

class MovieListViewModel : ViewModel() {

    private val movieRestApiTask = MovieRestApiTask()
    private val movieRepository = MovieRepository(movieRestApiTask)

    companion object {
        const val tag = "MovieListViewModel"
    }

    private var _moviesList = MutableLiveData<List<Movie>>()

    val moviesList: LiveData<List<Movie>>
        get() = _moviesList

    fun ini() {
        getAllMovies()
    }

    private fun getAllMovies() {
        // Suggestion: Use Coroutines or RxJava
        Thread {
            try {
                _moviesList.postValue(movieRepository.getAllMovies())
            } catch (exception: Exception) {
                Log.d(tag, exception.message.toString())
            }
        }.start()
    }
}