package com.example.cloneshopee.home.viewModels.menu

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.viewpager.widget.ViewPager
import com.example.cloneshopee.home.models.menuModel.ShopModel
import kotlin.coroutines.coroutineContext

class ThucPhamViewModel: ViewModel() {
    private val _position = MutableLiveData<Int>()
    val position : LiveData<Int>
        get() = _position

    private val _currentShopList = MutableLiveData<ArrayList<ShopModel>>()
    val currentShopList: LiveData<ArrayList<ShopModel>>
        get() = _currentShopList

    init {
        Log.i("ViewModel", "Created view model")
        _position.value = 0
        _currentShopList.value = ArrayList()
    }

    override fun onCleared() {
        super.onCleared()
        Log.i("ViewModel", "Cleared view model")
    }

    fun onPositionChanged(newPosition: Int){
        _position.value = newPosition
    }

    fun onShopListChanged(newCurrentShopList: ArrayList<ShopModel>){
        _currentShopList.value = newCurrentShopList
    }
}