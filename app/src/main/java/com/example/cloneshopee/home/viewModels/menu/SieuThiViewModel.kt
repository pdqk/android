package com.example.cloneshopee.home.viewModels.menu

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SieuThiViewModel: ViewModel() {
    private val _position = MutableLiveData<Int>()
    val position : LiveData<Int>
        get() = _position

    init {
        Log.i("ViewModel", "Created view model")
        _position.value = 0
    }

    override fun onCleared() {
        super.onCleared()
        Log.i("ViewModel", "Cleared view model")
    }

    fun onPositionChanged(newPosition: Int){
        _position.value = newPosition
    }
}