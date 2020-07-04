package com.example.cloneshopee.home.viewModels.dish

import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cloneshopee.home.models.dish.CartModel

class AllCartPriceViewModel : ViewModel() {
    private val _allCartPrice = MutableLiveData<Long>()
    val allCartPrice : LiveData<Long>
        get() = _allCartPrice

    private val _lishDish = MutableLiveData<ArrayList<CartModel>>()
    val lishDish : LiveData<ArrayList<CartModel>>
        get() = _lishDish

    init {
        _allCartPrice.value = 0
        _lishDish.value = ArrayList()
    }

    fun onAddDishToCart(name: String, price: Long, amount: Long){
        _lishDish.value!!.add(CartModel(name,price,amount))
    }

    fun onClearDishFromCart(){
        _lishDish.value!!.clear()
    }

    fun onPlusPrice(activity: FragmentActivity, newPrice: Long){
        val sharedPreferences = activity.getSharedPreferences("CurrentCart", 0)
        val cartprice = sharedPreferences.getLong("cartprice", 0)
        val editor = sharedPreferences.edit()
        _allCartPrice.value = cartprice + newPrice
        editor.putLong("cartprice", cartprice + newPrice)
        editor.apply()
        editor.commit()
    }

    fun onClearPrice(activity: FragmentActivity){
        _allCartPrice.value = 0
        val sharedPreferences = activity.getSharedPreferences("CurrentCart", 0)
        val editor = sharedPreferences.edit()
        editor.remove("cartprice")
        editor.apply()
        editor.commit()
    }
}