package com.devdroiddev.dagger2_mvvm.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.devdroiddev.dagger2_mvvm.models.Products
import com.devdroiddev.dagger2_mvvm.repository.ProductRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor(private val productRepository: ProductRepository) : ViewModel() {

    private val _data = MutableLiveData<List<Products>>()
    val data: LiveData<List<Products>> get() = _data
    init {
        fetchProducts()
    }

    private fun fetchProducts() {
        GlobalScope.launch(Dispatchers.IO) {
            val result = productRepository.getProducts()
            _data.postValue(result)
        }
    }

}