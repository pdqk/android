package com.example.cloneshopee.home.displaySearch

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.cloneshopee.R
import com.example.cloneshopee.databinding.DisplaySearch2Binding
import com.example.cloneshopee.home.coroutines.search.CoroutineSearchBackNavigation
import com.example.cloneshopee.home.coroutines.search.CoroutineSearchBackNavigation2
import com.example.cloneshopee.home.displayProducts.DisplayCart
import com.example.cloneshopee.home.viewModels.dish.AllCartPriceViewModel
import com.example.cloneshopee.home.viewModels.dish.GioHangViewModel
import com.example.cloneshopee.home.viewModels.search.SearchViewModel2
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job

class Search2Activity : AppCompatActivity() {
    private lateinit var displaySearch2Binding: DisplaySearch2Binding
    private lateinit var searchViewModel2: SearchViewModel2
    private lateinit var gioHangViewModel: GioHangViewModel
    private lateinit var allCartPriceViewModel: AllCartPriceViewModel

    private val searchJob = Job()
    private val searchScope = CoroutineScope(searchJob + Dispatchers.Main)

    private val backNavigateJob = Job()
    private val backNavigateScope = CoroutineScope(backNavigateJob + Dispatchers.Main)
    private val coroutineSearchBackNavigation2 = CoroutineSearchBackNavigation2()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        displaySearch2Binding = DataBindingUtil.setContentView(this, R.layout.display_search_2)
        searchViewModel2 = ViewModelProviders.of(this).get(SearchViewModel2::class.java)
        gioHangViewModel = ViewModelProviders.of(this).get(GioHangViewModel::class.java)
        allCartPriceViewModel = ViewModelProviders.of(this).get(AllCartPriceViewModel::class.java)

        onSearching()
        navToHomePage()
        setupGioHang()
        setupCart()

        window.apply {
            clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
            statusBarColor = Color.TRANSPARENT
        }
    }

    private fun setupGioHang(){
        gioHangViewModel.addToCart.observe(this, Observer { newState ->
            if(newState == true){
                displaySearch2Binding.llGioHang.visibility = View.VISIBLE
            }else{
                displaySearch2Binding.llGioHang.visibility = View.INVISIBLE
            }
        })

        displaySearch2Binding.btnThanhToan.setOnClickListener {
            gioHangViewModel.onClearCart()
            val fm = supportFragmentManager
            val displayCart = DisplayCart()
            displayCart.show(fm, "TAG")
        }
    }

    private fun setupCart(){
        allCartPriceViewModel.allCartPrice.observe(this, Observer { newPrice ->
            displaySearch2Binding.txtvAllCartPrice.text = (newPrice).toString() + "đ"
        })
    }

    private fun onSearching(){
        displaySearch2Binding.imgvSearch.setOnClickListener {
            searchViewModel2.onCoroutineGetResult(searchScope, this, displaySearch2Binding)
        }
    }

    private fun navToHomePage(){
        coroutineSearchBackNavigation2.onBackNavigating(backNavigateScope, this, displaySearch2Binding)
    }

    override fun onStop() {
        super.onStop()
        coroutineSearchBackNavigation2.onDone(backNavigateJob)
        gioHangViewModel.onClearCart()
        allCartPriceViewModel.onClearPrice(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        coroutineSearchBackNavigation2.onDone(backNavigateJob)
        gioHangViewModel.onClearCart()
        allCartPriceViewModel.onClearPrice(this)
    }
}
