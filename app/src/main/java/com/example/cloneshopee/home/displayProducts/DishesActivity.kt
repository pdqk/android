package com.example.cloneshopee.home.displayProducts

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.cloneshopee.R
import com.example.cloneshopee.databinding.AllDishesOfTheShopBinding
import com.example.cloneshopee.home.coroutines.dish.CoroutineGetDish
import com.example.cloneshopee.home.models.dish.DishModel
import com.example.cloneshopee.home.recyclerViewAdapter.dish.DishAdapter
import com.example.cloneshopee.home.viewModels.dish.AllCartPriceViewModel
import com.example.cloneshopee.home.viewModels.dish.DishViewModel
import com.example.cloneshopee.home.viewModels.dish.GioHangViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job

class DishesActivity : AppCompatActivity() {
    private lateinit var allDishesOfTheShopBinding: AllDishesOfTheShopBinding

    private lateinit var gioHangViewModel: GioHangViewModel
    private lateinit var allCartPriceViewModel: AllCartPriceViewModel

    private var dishOfThucPhamJob = Job()
    private var coroutineGetDishOfThucPhamScope = CoroutineScope(dishOfThucPhamJob + Dispatchers.Main)
    private var coroutineGetDishOfThucPham = CoroutineGetDish()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        allDishesOfTheShopBinding = DataBindingUtil.setContentView(this, R.layout.all_dishes_of_the_shop)

        gioHangViewModel = ViewModelProviders.of(this).get(GioHangViewModel::class.java)
        allCartPriceViewModel = ViewModelProviders.of(this).get(AllCartPriceViewModel::class.java)

        setupRecyclerDish()
        setupGioHang()
        setupCart()

        window.apply {
            clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
            statusBarColor = Color.TRANSPARENT
        }
    }

    private fun setupRecyclerDish(){
        coroutineGetDishOfThucPham.onCoroutineGetDish(coroutineGetDishOfThucPhamScope, this, allDishesOfTheShopBinding)
    }

    private fun setupGioHang(){
        gioHangViewModel.addToCart.observe(this, Observer { newState ->
            if(newState == true){
                allDishesOfTheShopBinding.llGioHang.visibility = View.VISIBLE
            }else{
                allDishesOfTheShopBinding.llGioHang.visibility = View.INVISIBLE
            }
        })

        allDishesOfTheShopBinding.btnThanhToan.setOnClickListener {
            gioHangViewModel.onClearCart()
            val fm = supportFragmentManager
            val displayCart = DisplayCart()
            displayCart.show(fm, "TAG")
        }
    }

    private fun setupCart(){
        allCartPriceViewModel.allCartPrice.observe(this, Observer { newPrice ->
            allDishesOfTheShopBinding.txtvAllCartPrice.text = (newPrice).toString() + "đ"
        })
    }

    override fun onStop() {
        super.onStop()
        coroutineGetDishOfThucPham.onCoroutineDone(dishOfThucPhamJob)
        gioHangViewModel.onClearCart()
        allCartPriceViewModel.onClearPrice(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        coroutineGetDishOfThucPham.onCoroutineDone(dishOfThucPhamJob)
        gioHangViewModel.onClearCart()
        allCartPriceViewModel.onClearPrice(this)
    }
}
