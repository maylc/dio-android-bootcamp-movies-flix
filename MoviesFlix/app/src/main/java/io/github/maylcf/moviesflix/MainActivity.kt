package io.github.maylcf.moviesflix

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import io.github.maylcf.moviesflix.databinding.ActivityMainBinding
import io.github.maylcf.moviesflix.model.Movie

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val listOfMovies = arrayListOf<Movie>(
        Movie(0, "Titanic", null, null, null),
        Movie(1, "Up", null, null, null),
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        populateList()
    }

    private fun populateList() {
        binding.moviesList.apply {
            hasFixedSize()
            adapter = MoviesAdapter(listOfMovies)
        }
    }
}