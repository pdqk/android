package com.example.cloneshopee.home.viewModels.dish

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GioHangViewModel :ViewModel() {
    private val _addToCart = MutableLiveData<Boolean>()
    val addToCart : LiveData<Boolean>
        get() = _addToCart

    init {
        _addToCart.value = false
    }

    fun onAddToCart(){
        _addToCart.value = true
    }

    fun onClearCart(){
        _addToCart.value = false
    }
}