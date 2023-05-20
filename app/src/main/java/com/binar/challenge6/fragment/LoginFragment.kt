@file:Suppress("RedundantNullableReturnType", "RedundantNullableReturnType",
    "RedundantNullableReturnType", "CanBeVal", "CanBeVal", "CanBeVal", "CanBeVal"
)

package com.binar.challenge6.fragment

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.binar.challenge6.R
import com.binar.challenge6.databinding.FragmentLoginBinding
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.AndroidEntryPoint

@Suppress("RedundantNullableReturnType", "RedundantNullableReturnType",
    "RedundantNullableReturnType", "CanBeVal", "CanBeVal", "CanBeVal", "CanBeVal", "CanBeVal"
)
@AndroidEntryPoint
class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding
    private lateinit var auth : FirebaseAuth
    private lateinit var sharedPref : SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {

        // Inflate the layout for this fragment
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sharedPref = requireActivity().getSharedPreferences("REGISTERUSER", Context.MODE_PRIVATE)
        auth = FirebaseAuth.getInstance()
        toRegister()
        toLogin()

    }
    private fun toRegister() {
        binding.textBpa.setOnClickListener {
            it.findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
        }
    }

    private fun toLogin(){
        binding.btnLogin.setOnClickListener {
            var email = binding.etEmail.text.toString()
            var password = binding.etPassword.text.toString()


            if(email.isNotEmpty() && password.isNotEmpty()){
                auth.signInWithEmailAndPassword(email, password).addOnCompleteListener{
                    if (it.isSuccessful){
                        Toast.makeText(context, "Login Successful", Toast.LENGTH_SHORT).show()
                        findNavController().navigate(R.id.action_loginFragment_to_homeFragment)
                    }else{
                        Toast.makeText(context, it.exception.toString(), Toast.LENGTH_SHORT).show()
                    }
                }

            }else{
                Toast.makeText(context, "Kata sandi harus di isi", Toast.LENGTH_SHORT).show()
            }
        }

    }




}