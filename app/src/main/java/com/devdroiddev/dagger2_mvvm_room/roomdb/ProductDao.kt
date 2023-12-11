package com.devdroiddev.dagger2_mvvm_room.roomdb

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.devdroiddev.dagger2_mvvm.models.Products

@Dao
interface ProductDao {

    @Insert
    suspend fun insertProduct(product : List<Products>)

    @Query("SELECT * FROM Products")
    fun getProducts() : LiveData<List<Products>>
}