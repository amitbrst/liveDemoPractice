package com.pretty.myprettyliveapplication.service.viewmodel

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.pretty.myprettyliveapplication.service.model.LoginRequest
import com.pretty.myprettyliveapplication.service.model.LoginResponse
import com.pretty.myprettyliveapplication.service.repository.login.LoginRepository

class LoginViewModel : ViewModel() {
    private var loginLiveData: MutableLiveData<LoginResponse?>? = null

    fun login(loginRequest: LoginRequest) : MutableLiveData<LoginResponse?>? {
        Log.i("kjsdjkdss", "login: sdxcsdsdscdc")
        loginLiveData = LoginRepository.getLoginApiCall(loginRequest)
        return loginLiveData
    }
}