@file:Suppress("KotlinConstantConditions", "RemoveCurlyBracesFromTemplate",
    "RedundantNullableReturnType", "RedundantNullableReturnType", "RedundantNullableReturnType",
    "RedundantNullableReturnType", "RedundantNullableReturnType", "RedundantNullableReturnType",
    "LiftReturnOrAssignment", "SpellCheckingInspection", "SpellCheckingInspection",
    "SpellCheckingInspection", "SpellCheckingInspection", "SpellCheckingInspection",
    "SpellCheckingInspection", "SpellCheckingInspection", "SpellCheckingInspection",
    "SpellCheckingInspection", "SpellCheckingInspection", "SpellCheckingInspection",
    "SpellCheckingInspection", "SpellCheckingInspection", "SpellCheckingInspection", "unused",
    "unused", "unused", "unused", "unused", "unused", "unused", "unused", "unused", "unused",
    "unused", "unused", "unused", "unused", "unused", "unused", "unused", "unused", "unused",
    "unused", "unused", "unused", "unused", "unused"
)

package com.binar.challenge6.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.binar.challenge6.R
import com.binar.challenge6.database.FavoriteMovie
import com.binar.challenge6.databinding.FragmentDetailBinding
import com.binar.challenge6.viewmodel.DetailViewModel
import com.bumptech.glide.Glide
import dagger.hilt.android.AndroidEntryPoint
import kotlin.properties.Delegates

@Suppress("KotlinConstantConditions", "RemoveCurlyBracesFromTemplate",
    "RedundantNullableReturnType", "RedundantNullableReturnType", "RedundantNullableReturnType",
    "RedundantNullableReturnType", "RedundantNullableReturnType", "RedundantNullableReturnType",
    "LiftReturnOrAssignment", "SpellCheckingInspection", "SpellCheckingInspection",
    "SpellCheckingInspection", "SpellCheckingInspection", "SpellCheckingInspection",
    "SpellCheckingInspection", "SpellCheckingInspection", "SpellCheckingInspection",
    "SpellCheckingInspection", "SpellCheckingInspection", "SpellCheckingInspection",
    "SpellCheckingInspection", "SpellCheckingInspection", "SpellCheckingInspection", "unused",
    "unused", "unused", "unused", "unused", "unused", "unused"
)
@AndroidEntryPoint
class DetailFragment : Fragment() {
    private lateinit var binding: FragmentDetailBinding
    private lateinit var viewModel: DetailViewModel
    private lateinit var selectMovie: FavoriteMovie
    private var isFavorite by Delegates.notNull<Boolean>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailBinding.inflate(layoutInflater,container,false)
        // Inflate the layout for this fragment
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[DetailViewModel::class.java]
        val id = arguments?.getInt("ID")
        if (id != null) {
            viewModel.getMovieById(id)
            observerDetailMovie()
            setFavoriteListener()
            checkFavoriteMovie(id)


        }
    }


//        val getData = arguments?.getSerializable("data_movie") as Result
//
//        val title = getData.title
//        val rilis = getData.releaseDate
//        val deskripsi = getData.overview
//        val image = getData.backdropPath
//
//        binding.titleMovie.text = title
//        binding.releaseDataMovie.text = rilis
//        binding.descMovie.text = deskripsi
//
//        Glide.with(view.context).load("https://image.tmdb.org/t/p/w780${image}")
//            .into(binding.movieImage)

    private fun observerDetailMovie(){
        viewModel.movie.observe(viewLifecycleOwner) {
            binding.apply {
                if (it != null) {
                    titleMovie.text = it.title.toString()
                    releaseDataMovie.text = it.releaseDate.toString()
                    Glide.with(requireContext())
                        .load("https://image.tmdb.org/t/p/w500/" + it.backdropPath)
                        .into(binding.movieImage)
                    descMovie.text = it.overview.toString()
                    selectMovie = FavoriteMovie(
                        it.id!!,
                        it.title!!,
                        it.releaseDate!!,
                        it.posterPath!!
                    )
                }
            }
        }

    }

    private fun setFavoriteListener() {
        binding.fabFav.apply {
            setOnClickListener {
                if (!isFavorite) {
                    addToFavorite(selectMovie)
                    binding.fabFav.setImageResource(R.drawable.ic_fav)
                    isFavorite = true
                } else {
                    deleteFromFavorite(selectMovie)
                    binding.fabFav.setImageResource(R.drawable.ic_not_fav)
                    isFavorite = false
                }
            }
        }
    }

    private fun addToFavorite(movie: FavoriteMovie) {
        viewModel.addFavMovie(movie)
        viewModel.favMovie.observe(viewLifecycleOwner) {
            if (it != null) {
                Toast.makeText(requireContext(), "Berhasil ditambah favorit", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(requireContext(), "Gagal menambah favorit", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }
    private fun deleteFromFavorite(movie: FavoriteMovie) {
        viewModel.deleteFavMovie(movie)
        viewModel.deleteFavMovie.observe(viewLifecycleOwner) {
            if (it != null) {
                Toast.makeText(requireContext(), "Berhasil menghapus favorit", Toast.LENGTH_SHORT)
                    .show()
            } else {
                Toast.makeText(requireContext(), "Gagal menghapus favorit", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }


    private fun checkFavoriteMovie(movieId: Int) {
        viewModel.isFavoriteMovie(movieId)
        viewModel.isFav.observe(viewLifecycleOwner) {
            if (it != null) {
                if (it) {
                    isFavorite = true
                    binding.fabFav.setImageResource(R.drawable.ic_fav)
                } else {
                    isFavorite = false
                    binding.fabFav.setImageResource(R.drawable.ic_not_fav)
                }
            } else {
                Log.d("CHECK_FAV", "checkFavoriteMovie: ${it}")
            }
        }
    }


}