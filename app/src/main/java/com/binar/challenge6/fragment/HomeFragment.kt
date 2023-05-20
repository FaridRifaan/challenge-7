package com.binar.challenge6.fragment

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.binar.challenge6.R
import com.binar.challenge6.adapter.MovieAdapter
import com.binar.challenge6.databinding.FragmentHomeBinding
import com.binar.challenge6.viewmodel.ViewModelMovie
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var viewModelHome: ViewModelMovie
    private lateinit var auth : FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModelHome = ViewModelProvider(this)[ViewModelMovie::class.java]
        observeMovie()

        sharedPreferences = requireContext().getSharedPreferences("REGISTERUSER", Context.MODE_PRIVATE)

        var getUsername = sharedPreferences.getString("USER", "")
        binding.txtWelcomeUsername.text = "Wellcome, $getUsername"

        binding.imgProfile.setOnClickListener {
            var addUser = sharedPreferences.edit()
            addUser.putString("USER", getUsername)
            addUser.apply()
            Navigation.findNavController(binding.root).navigate(R.id.action_homeFragment_to_profileFragment)
        }
        binding.imgLove.setOnClickListener {
            Navigation.findNavController(binding.root).navigate(R.id.action_homeFragment_to_favoriteFragment)
        }
    }

    private fun observeMovie(){
        binding.movieRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.movieRecyclerView.setHasFixedSize(false)
        viewModelHome.setMoviesList()
        viewModelHome.movie.observe(viewLifecycleOwner) {
            if (it != null) {
                binding.movieRecyclerView.adapter = MovieAdapter(it)
            }
        }
    }


}