package com.binar.challenge6.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.binar.challenge6.R
import com.binar.challenge6.databinding.FragmentFavoriteBinding
import com.binar.challenge6.databinding.FragmentProfileBinding


class FavoriteFragment : Fragment() {

    lateinit var binding : FragmentFavoriteBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentFavoriteBinding.inflate(inflater, container, false)
        return binding.root

    }
}