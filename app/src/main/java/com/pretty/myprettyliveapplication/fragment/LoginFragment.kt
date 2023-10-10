package com.pretty.myprettyliveapplication.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.pretty.myprettyliveapplication.R
import com.pretty.myprettyliveapplication.databinding.FragmentLoginBinding
import com.pretty.myprettyliveapplication.service.model.LoginRequest
import com.pretty.myprettyliveapplication.service.viewmodel.LoginViewModel


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


    private fun <T> LiveData<T>.observeOnce(observer1: FragmentActivity, observer: Observer<T>) {
        observeForever(object : Observer<T> {
            override fun onChanged(t: T) {
                observer.onChanged(t)
                removeObserver(this)
            }
        })
    }
    private fun init () {
        binding.btnLogin.setOnClickListener {
            val loginRequest = LoginRequest(email = "ak05836@gmail.com", password = "12345678")
            loginViewModel.login(loginRequest)!!.observeOnce(requireActivity(), Observer {
                if (it != null) {
                    Toast.makeText(requireActivity(), "data: ${it.message}", Toast.LENGTH_SHORT).show()
                }
            })
        }
        binding.btnCreateAccount.setOnClickListener {
            Navigation.findNavController(binding.root).navigate(R.id.action_loginFragment_to_registerFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}