package com.pretty.myprettyliveapplication.service.repository.login

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.pretty.myprettyliveapplication.service.model.LoginRequest
import com.pretty.myprettyliveapplication.service.model.LoginResponse
import com.pretty.myprettyliveapplication.service.retrofit.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object LoginRepository {
    private val loginResponse = MutableLiveData<LoginResponse?>()
    fun getLoginApiCall(loginRequest:LoginRequest): MutableLiveData<LoginResponse?> {
        val call = RetrofitClient.apiInterface.getLogin(loginRequest)
        call.enqueue(object: Callback<LoginResponse> {
            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                Log.v("DEBUG : ", t.message.toString())
                loginResponse.postValue(LoginResponse(t.message.toString(),""))
            }

            override fun onResponse(
                call: Call<LoginResponse>,
                response: Response<LoginResponse>
            ) {
                if (response.isSuccessful) {
                    val data = response.body()
                    loginResponse.postValue(data)
                } else {
                    // Handle the case where the response is not successful (e.g., non-200 status code)
                    val errorMessage = "Somethings went wrong : ${response.code()}"
                    loginResponse.postValue(LoginResponse(errorMessage,""))
                }

            }
        })

        return loginResponse
    }

}