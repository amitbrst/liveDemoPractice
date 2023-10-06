package com.pretty.myprettyliveapplication.service.retrofit

import com.pretty.myprettyliveapplication.service.model.LoginRequest
import com.pretty.myprettyliveapplication.service.model.LoginResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiInterface {
    @GET("services")
    fun getServices() : Call<LoginResponse>

    @POST("signin")
    fun getLogin(@Body loginRequest: LoginRequest) : Call<LoginResponse>
}