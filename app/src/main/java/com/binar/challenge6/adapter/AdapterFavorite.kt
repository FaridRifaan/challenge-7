@file:Suppress("unused", "unused", "unused", "unused", "unused", "unused", "unused", "unused",
    "unused", "unused", "unused", "unused", "unused", "unused", "unused", "unused", "unused",
    "unused", "unused", "unused", "unused", "unused", "unused", "unused", "unused", "unused",
    "unused", "unused", "unused", "unused", "unused", "unused", "unused", "unused", "unused",
    "unused", "unused", "unused", "unused", "unused", "unused", "unused", "unused", "unused",
    "unused", "unused", "unused", "unused", "unused", "unused", "unused", "unused", "unused",
    "unused", "unused", "unused", "unused", "unused", "unused", "unused", "unused", "unused",
    "unused", "unused", "unused", "unused", "unused", "unused", "unused", "unused", "RedundantWith",
    "RemoveRedundantQualifierName", "RemoveRedundantQualifierName", "RemoveRedundantQualifierName",
    "RemoveRedundantQualifierName", "MemberVisibilityCanBePrivate", "MemberVisibilityCanBePrivate",
    "MemberVisibilityCanBePrivate", "MemberVisibilityCanBePrivate", "MemberVisibilityCanBePrivate",
    "MemberVisibilityCanBePrivate", "MemberVisibilityCanBePrivate", "MemberVisibilityCanBePrivate",
    "MemberVisibilityCanBePrivate", "MemberVisibilityCanBePrivate", "MemberVisibilityCanBePrivate",
    "MemberVisibilityCanBePrivate", "MemberVisibilityCanBePrivate"
)

package com.binar.challenge6.adapter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.binar.challenge6.R
import com.binar.challenge6.database.FavoriteMovie
import com.binar.challenge6.databinding.MovieListFavBinding
import com.bumptech.glide.Glide

@Suppress("unused", "unused", "unused", "unused", "unused", "unused", "unused", "unused", "unused",
    "unused", "unused", "unused", "unused", "unused", "unused", "unused", "unused", "unused",
    "unused", "unused", "unused", "unused", "unused", "unused", "unused", "unused", "unused",
    "unused", "unused", "unused", "unused", "unused", "unused", "unused", "unused", "unused",
    "unused", "unused", "unused", "unused", "unused", "unused", "unused", "unused", "unused",
    "unused", "unused", "unused", "unused", "unused", "unused", "unused", "unused", "unused",
    "unused", "unused", "unused", "unused", "unused", "unused", "unused", "unused", "unused",
    "unused", "unused", "unused", "unused", "unused", "unused", "unused",
    "RemoveRedundantQualifierName", "RemoveRedundantQualifierName", "RemoveRedundantQualifierName",
    "RemoveRedundantQualifierName", "MemberVisibilityCanBePrivate", "MemberVisibilityCanBePrivate",
    "MemberVisibilityCanBePrivate", "MemberVisibilityCanBePrivate", "MemberVisibilityCanBePrivate",
    "MemberVisibilityCanBePrivate", "MemberVisibilityCanBePrivate", "MemberVisibilityCanBePrivate",
    "MemberVisibilityCanBePrivate", "MemberVisibilityCanBePrivate", "MemberVisibilityCanBePrivate",
    "MemberVisibilityCanBePrivate", "MemberVisibilityCanBePrivate"
)
class AdapterFavorite(private var listMovie: List<FavoriteMovie>): RecyclerView.Adapter<AdapterFavorite.ViewHolder>() {
    class ViewHolder(var binding: MovieListFavBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(movie: FavoriteMovie) {
            with(itemView) {
                binding.apply {
                    titleMovie.text = movie.title
                    releaseMovie.text = movie.releasedate
                    Glide.with(itemView.context)
                        .load("https://image.tmdb.org/t/p/w400${movie.posterPath}")
                        .into(binding.imgMovie)
                    cardView.setOnClickListener{
                        val bundle = Bundle().apply {
                            putInt("ID", movie.id.toString().toInt())
                        }
                        it.findNavController().navigate(R.id.action_favoriteFragment_to_detailFragment, bundle)
                    }
                }
            }

        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterFavorite.ViewHolder {
        val view = MovieListFavBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: AdapterFavorite.ViewHolder, position: Int) =
        holder.bind(listMovie[position])

    override fun getItemCount(): Int = listMovie.size
}