package com.devdroiddev.dagger2_mvvm.repository

import android.util.Log
import com.devdroiddev.dagger2_mvvm.models.Products
import com.devdroiddev.dagger2_mvvm.network.StoreApi
import com.devdroiddev.dagger2_mvvm.utils.APP_TAG
import com.devdroiddev.dagger2_mvvm_room.roomdb.ProductDao
import javax.inject.Inject

class ProductRepository @Inject constructor(private val storeApi: StoreApi, private val productDao: ProductDao) {

    suspend fun getProducts(): List<Products> {
        val result = storeApi.getProducts()
        return if (result.isSuccessful && result.body() != null) {
            productDao.insertProduct(result.body()!!)
            result.body()!!
        } else {
            Log.d(APP_TAG, "Error")
            emptyList()
        }
    }

}