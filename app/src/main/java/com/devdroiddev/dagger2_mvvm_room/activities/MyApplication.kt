package com.devdroiddev.dagger2_mvvm.activities

import android.app.Application
import com.devdroiddev.dagger2_mvvm.di.ApplicationComponent
import com.devdroiddev.dagger2_mvvm.di.DaggerApplicationComponent


class MyApplication : Application() {

    lateinit var applicationComponent : ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        applicationComponent = DaggerApplicationComponent.factory().create(applicationContext)
    }
}