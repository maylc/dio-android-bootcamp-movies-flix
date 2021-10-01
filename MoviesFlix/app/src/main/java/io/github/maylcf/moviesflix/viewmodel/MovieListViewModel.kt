package io.github.maylcf.moviesflix.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.github.maylcf.moviesflix.model.Movie

class MovieListViewModel: ViewModel() {

    private val listOfMovies = arrayListOf<Movie>(
        Movie(0, "Titanic", null, null, null),
        Movie(1, "Up", null, null, null),
    )

    private var _moviesList = MutableLiveData<List<Movie>>()

    val moviesList: LiveData<List<Movie>>
        get() = _moviesList

    fun ini() {
        getAllMovies()
    }

    private fun getAllMovies() {
        _moviesList.value = listOfMovies
    }
}