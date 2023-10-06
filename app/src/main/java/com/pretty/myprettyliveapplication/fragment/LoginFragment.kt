package com.pretty.myprettyliveapplication.fragment

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.google.gson.Gson
import com.pretty.myprettyliveapplication.R
import com.pretty.myprettyliveapplication.databinding.FragmentLoginBinding
import com.pretty.myprettyliveapplication.service.model.LoginRequest
import com.pretty.myprettyliveapplication.service.viewmodel.LoginViewModel
import com.pretty.myprettyliveapplication.utils.ShowCustomToast


class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    lateinit var loginViewModel: LoginViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        loginViewModel = ViewModelProvider(requireActivity())[LoginViewModel::class.java]

        init()
        return binding.root
    }

    private fun init () {
        binding.btnCreateAccount.setOnClickListener {
            val loginRequest = LoginRequest(email = "ak05836@gmail.com", password = "12345678")

// Convert the LoginRequest object to JSON using a library like Gson
//            val gson = Gson()
//            val json = gson.toJson(loginRequest)
            loginViewModel.login(loginRequest)!!.observe(requireActivity(), Observer {

                Log.i("amit", "response data :"+it)
                Toast.makeText(requireActivity(), "data :"+it?.message, Toast.LENGTH_SHORT).show()

            })
//            Navigation.findNavController(binding.root).navigate(R.id.action_loginFragment_to_registerFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}