package com.devdroiddev.dagger2_mvvm.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.devdroiddev.dagger2_mvvm.utils.APP_TAG
import com.devdroiddev.dagger2_mvvm.viewModels.MainViewModel
import com.devdroiddev.dagger2_mvvm_room.R
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        (application as MyApplication).applicationComponent.inject(this)

        setUpObservers()
    }

    private fun setUpObservers() {

        mainViewModel.data.observe(this){ products ->
            if (products != null) {
                Log.d(APP_TAG, "Products size -> ${products.size}")
            } else {
                Log.d(APP_TAG, "No Products")
            }
        }
    }
}