package io.github.maylcf.moviesflix.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import io.github.maylcf.moviesflix.databinding.ActivityMainBinding
import io.github.maylcf.moviesflix.model.Movie
import io.github.maylcf.moviesflix.viewmodel.MovieListViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var movieListViewModel: MovieListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        movieListViewModel =
            ViewModelProvider.NewInstanceFactory().create(MovieListViewModel::class.java)
        movieListViewModel.ini()

        initObserver()
    }

    private fun initObserver() {
        movieListViewModel.moviesList.observe(this, { list ->
            populateList(list)
        })
    }

    private fun populateList(list: List<Movie>) {
        binding.moviesList.apply {
            hasFixedSize()
            adapter = MoviesAdapter(list)
        }
    }
}