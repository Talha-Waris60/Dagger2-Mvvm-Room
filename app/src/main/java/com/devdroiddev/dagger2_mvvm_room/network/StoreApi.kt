package com.devdroiddev.dagger2_mvvm.network

import retrofit2.Response
import retrofit2.http.GET
import com.devdroiddev.dagger2_mvvm.models.Products

interface StoreApi {

    @GET("products")
    suspend fun getProducts() : Response<List<Products>>
}