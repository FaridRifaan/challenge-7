package com.binar.challenge6.fragment

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import com.binar.challenge6.R
import com.binar.challenge6.databinding.FragmentProfileBinding
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProfileFragment : Fragment() {
    lateinit var binding : FragmentProfileBinding
    lateinit var sharedPref : SharedPreferences
    lateinit var auth: FirebaseAuth


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentProfileBinding.inflate(inflater, container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sharedPref = requireActivity().getSharedPreferences("REGISTERUSER", Context.MODE_PRIVATE)

        val getUser = sharedPref.getString("USER", "")
        binding.etUsername.setText(getUser)

        val getNama = sharedPref.getString("NAMALENGKAP", "")
        binding.etNamaLengkap.setText(getNama)

        val getTgl = sharedPref.getString("TANGGAL", "")
        binding.etTanggalLahir.setText(getTgl)

        val getAlamat = sharedPref.getString("ALAMAT", "")
        binding.etAlamat.setText(getAlamat)

        binding.btnUpdate.setOnClickListener {
            toUpdate()
        }

        binding.btnLogout.setOnClickListener {
            toLogout()
        }

    }
    private fun toUpdate(){
        val updateUsername = binding.etUsername.text.toString()
        val namaLengkap = binding.etNamaLengkap.text.toString()
        val ttl = binding.etTanggalLahir.text.toString()
        val alamat = binding.etAlamat.text.toString()
        var adduser = sharedPref.edit()
        adduser.putString("USER", updateUsername)
        adduser.putString("NAMALENGKAP", namaLengkap)
        adduser.putString("TANGGAL", ttl)
        adduser.putString("ALAMAT", alamat)
        adduser.apply()
        auth = FirebaseAuth.getInstance()
        auth.signOut()
        Toast.makeText(context, "Username Berhasil di update", Toast.LENGTH_SHORT).show()
        Navigation.findNavController(binding.root).navigate(R.id.action_profileFragment_to_homeFragment)

    }

    private fun toLogout(){
        auth = FirebaseAuth.getInstance()
        auth.signOut()
        Toast.makeText(context, "Anda telah logout :)", Toast.LENGTH_SHORT).show()
        Navigation.findNavController(binding.root).navigate(R.id.action_profileFragment_to_loginFragment)


    }


}