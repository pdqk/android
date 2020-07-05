package com.example.cloneshopee.home.displayProducts

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.cloneshopee.R
import com.example.cloneshopee.databinding.DishOrderBinding
import com.example.cloneshopee.home.coroutines.dish.CoroutineLoadImage
import com.example.cloneshopee.home.models.dish.CartModel
import com.example.cloneshopee.home.viewModels.dish.AllCartPriceViewModel
import com.example.cloneshopee.home.viewModels.dish.DishViewModel
import com.example.cloneshopee.home.viewModels.dish.GioHangViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job

class DisplayOrder: DialogFragment() {
    private lateinit var dishOrderBinding: DishOrderBinding

    private lateinit var dishViewModel: DishViewModel
    private lateinit var gioHangViewModel: GioHangViewModel
    private lateinit var allCartPriceViewModel: AllCartPriceViewModel

    private val coroutineImageJob = Job()
    private val coroutineImageScope = CoroutineScope(coroutineImageJob + Dispatchers.Main)
    private val coroutineLoadImage = CoroutineLoadImage()

    override fun onStart() {
        super.onStart()
        dialog?.window?.setLayout(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        dishOrderBinding = DataBindingUtil.inflate(inflater, R.layout.dish_order,container, false)

        dishViewModel = ViewModelProviders.of(activity!!).get(DishViewModel::class.java)
        gioHangViewModel = ViewModelProviders.of(activity!!).get(GioHangViewModel::class.java)
        allCartPriceViewModel = ViewModelProviders.of(activity!!).get(AllCartPriceViewModel::class.java)

        uiControl()
        closeOrder()
        setupImage()

        return dishOrderBinding.root
    }

    private fun closeOrder(){
        dishOrderBinding.btnCloseOrder.setOnClickListener {
            dismiss()
            dishViewModel.onDismiss()
            coroutineLoadImage.onCoroutineDone(coroutineImageJob)
        }
    }

    private fun setupImage(){
        coroutineLoadImage.onCoroutineLoadImage(coroutineImageScope, activity!!, dishOrderBinding)
    }

    private fun uiControl(){
        val sharedPreferences = activity!!.getSharedPreferences("CurrentDishOrdered", 0)
        val dishprice = sharedPreferences.getLong("dishprice", 0)
        val dishname = sharedPreferences.getString("dishname", "")
        val dishlike = sharedPreferences.getString("dishlike", "")

        dishOrderBinding.txtvOrderName.text = dishname
        dishOrderBinding.txtvOrderLike.text = dishlike
        dishOrderBinding.txtvOrderPrice.text = dishprice.toString() + "đ"

        dishViewModel.amount.observe(activity!!, Observer { newAmount ->
            if(newAmount >= 1){
                dishOrderBinding.btnDesOrder.setOnClickListener {
                    dishViewModel.onAmountDec()
                }
                dishOrderBinding.btnIncOrder.setOnClickListener {
                    dishViewModel.onAmountInc()
                }
            }
            dishOrderBinding.txtvOrderAmount.text = newAmount.toString()
            dishOrderBinding.txtvOrderPriceSum.text = (newAmount * dishprice).toString() + "đ"

            dishOrderBinding.btnThemVaoGioHang.setOnClickListener {
                allCartPriceViewModel.onAddDishToCart(dishname!!,dishprice,newAmount)

                dismiss()
                allCartPriceViewModel.onPlusPrice(activity!!, newAmount * dishprice)
                gioHangViewModel.onAddToCart()
                dishViewModel.onDismiss()
                coroutineLoadImage.onCoroutineDone(coroutineImageJob)
            }
        })
    }

    override fun onStop() {
        super.onStop()
        coroutineLoadImage.onCoroutineDone(coroutineImageJob)
    }

    override fun onDestroy() {
        super.onDestroy()
        coroutineLoadImage.onCoroutineDone(coroutineImageJob)
    }

}