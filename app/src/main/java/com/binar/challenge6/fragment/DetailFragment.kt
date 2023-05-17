package com.binar.challenge6.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.binar.challenge6.R
import com.binar.challenge6.databinding.FragmentDetailBinding
import com.bumptech.glide.Glide
import com.binar.challenge6.model.Result


class DetailFragment : Fragment() {
    lateinit var binding: FragmentDetailBinding


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
        val getData = arguments?.getSerializable("data_movie") as Result

        val title = getData.title
        val rilis = getData.releaseDate
        val deskripsi = getData.overview
        val image = getData.backdropPath

        binding.titleMovie.text = title
        binding.releaseDataMovie.text = rilis
        binding.descMovie.text = deskripsi

        Glide.with(view.context).load("https://image.tmdb.org/t/p/w780${image}")
            .into(binding.movieImage)


    }


}