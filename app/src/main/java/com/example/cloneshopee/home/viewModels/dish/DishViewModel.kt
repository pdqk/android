package com.example.cloneshopee.home.viewModels.dish

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DishViewModel : ViewModel() {
    var index = 1

    private val _amount = MutableLiveData<Long>()
    val amount : LiveData<Long>
        get() = _amount

    init {
        _amount.value = 1
        index = 1
    }

    override fun onCleared() {
        super.onCleared()
        Log.i("ViewModel", "Cleared view model")
    }

    fun onAmountInc(){
        if(index >= 1){
            _amount.value = _amount.value!!.plus(1)
            index += 1
        }
    }

    fun onAmountDec(){
        if(index > 1){
            _amount.value = _amount.value!!.minus(1)
            index -= 1
        }
    }

    fun onDismiss(){
        _amount.value = 1
        index = 1
    }
}