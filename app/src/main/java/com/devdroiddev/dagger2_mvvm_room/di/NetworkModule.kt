package com.devdroiddev.dagger2_mvvm.di

import com.devdroiddev.dagger2_mvvm.network.StoreApi
import com.devdroiddev.dagger2_mvvm.utils.BASE_URL
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module()
class NetworkModule {

    @Singleton
    @Provides // -> This method provides the instance that's why annotated it with @Provides
    fun provideRetrofit() : Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun providesStoreApi(retrofit: Retrofit) : StoreApi {
        return retrofit.create(StoreApi::class.java)
    }
}