package com.devdroiddev.dagger2_mvvm.di

import android.content.Context
import com.devdroiddev.dagger2_mvvm.activities.MainActivity
import com.devdroiddev.dagger2_mvvm_room.roomdb.DatabaseModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class, DatabaseModule::class])
interface ApplicationComponent {

    fun inject(mainActivity: MainActivity)

    // Factory to get applicationContext at runtime
    @Component.Factory
    interface Factory{

        // Create a MyComponent instance and bind the provided context, using @BindsInstance, making it available for injection.
        fun create(@BindsInstance context: Context) : ApplicationComponent
    }
}