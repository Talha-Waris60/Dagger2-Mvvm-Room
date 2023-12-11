package com.devdroiddev.dagger2_mvvm_room.roomdb

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun provideRoomDb(context: Context) : AppDatabase {
        return Room.databaseBuilder(context,
            AppDatabase::class.java
        ,"Product_Db").build()
    }

    @Singleton
    @Provides
    fun provideProductDao(appDatabase: AppDatabase) : ProductDao {
        return appDatabase.productDao()
    }
}