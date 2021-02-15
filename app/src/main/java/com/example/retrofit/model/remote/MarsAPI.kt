package com.example.retrofit.model.remote

import retrofit2.Response
import retrofit2.http.GET

interface MarsAPI {

    @GET("realestate")
    suspend fun fetchMarsData() : Response<List<MarsEstate>>

}