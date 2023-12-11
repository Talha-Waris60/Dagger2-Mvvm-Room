package com.devdroiddev.dagger2_mvvm_room.roomdb

import androidx.room.Database
import androidx.room.RoomDatabase
import com.devdroiddev.dagger2_mvvm.models.Products

@Database(entities = [Products::class], version = 1)
abstract class AppDatabase : RoomDatabase(){

    abstract fun productDao() : ProductDao
}