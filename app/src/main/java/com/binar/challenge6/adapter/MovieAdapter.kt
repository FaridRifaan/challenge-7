@file:Suppress("RemoveRedundantQualifierName", "RemoveRedundantQualifierName",
    "PrivatePropertyName", "unused", "unused", "unused", "unused", "unused", "unused", "unused",
    "unused", "unused", "unused", "unused", "unused", "unused", "unused", "unused", "unused",
    "unused", "unused", "unused", "unused", "unused", "unused", "unused", "unused", "unused"
)

package com.binar.challenge6.adapter

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.binar.challenge6.R
import com.binar.challenge6.databinding.MovieListBinding
import com.binar.challenge6.model.Result
import com.bumptech.glide.Glide

@Suppress("RemoveRedundantQualifierName", "RemoveRedundantQualifierName", "PrivatePropertyName",
    "unused"
)
class MovieAdapter(private var listMovie: List<Result>): RecyclerView.Adapter<MovieAdapter.ViewHolder>() {
    class ViewHolder(private var binding: MovieListBinding): RecyclerView.ViewHolder(binding.root) {
        private val IMAGE_BASE = "https://image.tmdb.org/t/p/w500/"

        @SuppressLint("SetTextI18n")
        fun bindMovie(ItemsMovie : Result){
            binding.titleMovie.text = ItemsMovie.title
            binding.releaseMovie.text = "Release at: " + ItemsMovie.releaseDate
            Glide.with(itemView).load(IMAGE_BASE + ItemsMovie.posterPath).into(binding.imgMovie)
            binding.cardView.setOnClickListener {
                val bundle = Bundle().apply {
                    putInt("ID", ItemsMovie.id.toString().toInt())
                }
                it.findNavController().navigate(R.id.action_homeFragment_to_detailFragment2, bundle)
            }

        }



    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieAdapter.ViewHolder {
        val view = MovieListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: MovieAdapter.ViewHolder, position: Int) {
//        holder.binding.titleMovie.text = listMovie[position].title
//        holder.binding.releaseMovie.text = listMovie[position].releaseDate
//        Glide.with(holder.itemView)
//            .load("https://image.tmdb.org/t/p/w780${listMovie[position].backdropPath}")
//            .into(holder.binding.imgMovie)
//        holder.binding.cardView.setOnClickListener{
//            val bundle = Bundle()
//            bundle.putSerializable("data_movie", listMovie[position])
//            Navigation.findNavController(it).navigate(R.id.action_homeFragment_to_detailFragment2, bundle)
//        }
        holder.bindMovie(listMovie[position])
    }

    override fun getItemCount(): Int = listMovie.size
}