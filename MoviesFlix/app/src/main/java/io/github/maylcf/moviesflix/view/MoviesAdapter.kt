package io.github.maylcf.moviesflix.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import io.github.maylcf.moviesflix.R
import io.github.maylcf.moviesflix.model.Movie

class MoviesAdapter(private val moviesList: List<Movie>): RecyclerView.Adapter<MoviesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.movie_item, parent, false)
        return MoviesViewHolder(view)
    }

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        val imageView = holder.itemView.findViewById<AppCompatImageView>(R.id.movieImage)
        val titleView = holder.itemView.findViewById<AppCompatTextView>(R.id.movieTitle)

        titleView.text = moviesList[position].title

        imageView.load(moviesList[position].image) {
            placeholder(R.drawable.ic_photo)
            fallback(R.drawable.ic_photo)
        }
    }

    override fun getItemCount(): Int = moviesList.size
}

class MoviesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)