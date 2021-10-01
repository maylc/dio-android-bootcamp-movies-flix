package io.github.maylcf.moviesflix.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.github.maylcf.moviesflix.api.MovieRestApiTask
import io.github.maylcf.moviesflix.data.MovieRepository
import io.github.maylcf.moviesflix.domain.Movie
import io.github.maylcf.moviesflix.implementation.MovieDataSourceImplementation
import io.github.maylcf.moviesflix.usecase.MovieListUseCase

class MovieListViewModel : ViewModel() {

    private val movieRestApiTask = MovieRestApiTask()
    private val movieDataSource = MovieDataSourceImplementation(movieRestApiTask)
    private val movieRepository = MovieRepository(movieDataSource)
    private val movieListUseCase = MovieListUseCase(movieRepository)

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
                _moviesList.postValue(movieListUseCase.invoke())
            } catch (exception: Exception) {
                Log.d(tag, exception.message.toString())
            }
        }.start()
    }
}