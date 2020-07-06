package com.example.cloneshopee.home.displayProducts

import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cloneshopee.R
import com.example.cloneshopee.databinding.CartBinding
import com.example.cloneshopee.home.displayLocation.MapsActivity
import com.example.cloneshopee.home.models.dish.CartModel
import com.example.cloneshopee.home.recyclerViewAdapter.dish.CartAdapter
import com.example.cloneshopee.home.viewModels.dish.AllCartPriceViewModel
import com.example.cloneshopee.home.viewModels.dish.GioHangViewModel

class DisplayCart: DialogFragment() {
    private lateinit var cartBinding: CartBinding

    private lateinit var allCartPriceViewModel: AllCartPriceViewModel
    private lateinit var gioHangViewModel: GioHangViewModel

    override fun onStart() {
        super.onStart()
        dialog?.window?.setLayout(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        cartBinding = DataBindingUtil.inflate(inflater, R.layout.cart, container, false)

        allCartPriceViewModel = ViewModelProviders.of(activity!!).get(AllCartPriceViewModel::class.java)
        gioHangViewModel = ViewModelProviders.of(activity!!).get(GioHangViewModel::class.java)

        setupCart()
        closeCart()
        deleteAllDishesInCart()
        thanhToan()
        setupRecyclerView()

        return cartBinding.root
    }

    private fun setupCart(){
        allCartPriceViewModel.allCartPrice.observe(activity!!, Observer { newPrice ->
            cartBinding.txtvAllCartPrice2.text = newPrice.toString() + "đ"
        })
    }

    private fun closeCart(){
        cartBinding.btnCloseCart.setOnClickListener {
            val sharedPreferences = activity!!.getSharedPreferences("CurrentCart", 0)
            val cartprice = sharedPreferences.getLong("cartprice", 0).toInt()
            if(cartprice == 0){
                dismiss()
                gioHangViewModel.onClearCart()
            }else{
                dismiss()
                gioHangViewModel.onAddToCart()
            }
        }
    }

    private fun deleteAllDishesInCart(){
        cartBinding.txtvDeleteAll.setOnClickListener {
            val builder = AlertDialog.Builder(activity)
            builder.setTitle("Xóa tất cả")
            builder.setMessage("Bạn có chắc muốn xóa toàn bộ giỏ hàng không?")
            builder.setPositiveButton("Đồng ý"){dialog, which ->
                dismiss()
                gioHangViewModel.onClearCart()
                allCartPriceViewModel.onClearPrice(activity!!)
                allCartPriceViewModel.onClearDishFromCart()
            }
            builder.setNegativeButton("Không"){dialog, which ->  }
            builder.show()
        }
    }

    private fun thanhToan(){
        cartBinding.btnThanhToan2.setOnClickListener {
            gioHangViewModel.onClearCart()
            allCartPriceViewModel.onClearPrice(activity!!)
            allCartPriceViewModel.onClearDishFromCart()
            dismiss()
            val intent = Intent(activity!!, MapsActivity::class.java)
            startActivity(intent)
        }
    }

    private fun setupRecyclerView(){
        allCartPriceViewModel.lishDish.observe(activity!!, Observer { newList ->
            val adapter = CartAdapter(newList, activity!!)
            cartBinding.recyclerCart.layoutManager = LinearLayoutManager(activity, RecyclerView.VERTICAL, false)
            cartBinding.recyclerCart.adapter = adapter
        })
    }
}