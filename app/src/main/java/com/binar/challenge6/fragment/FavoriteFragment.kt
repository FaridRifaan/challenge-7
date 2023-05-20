package com.binar.challenge6.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.binar.challenge6.R
import com.binar.challenge6.adapter.AdapterFavorite
import com.binar.challenge6.databinding.FragmentFavoriteBinding
import com.binar.challenge6.databinding.FragmentProfileBinding
import com.binar.challenge6.viewmodel.FavoriteViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavoriteFragment : Fragment() {

    private  var _binding : FragmentFavoriteBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel : FavoriteViewModel



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentFavoriteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[FavoriteViewModel::class.java]
        getAllFavMovies()

    }

    private fun getAllFavMovies(){
        viewModel.getAllFavoriteMovie()
        viewModel.listMovie.observe(viewLifecycleOwner){
            if(it != null){
                binding.favoriteReyclerView.layoutManager = LinearLayoutManager(requireContext())
                binding.favoriteReyclerView.setHasFixedSize(false)
                binding.favoriteReyclerView.adapter = AdapterFavorite(it)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}