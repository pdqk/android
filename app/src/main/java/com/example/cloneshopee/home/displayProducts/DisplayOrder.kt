package com.example.cloneshopee.home.displayProducts

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.cloneshopee.R
import com.example.cloneshopee.databinding.DishOrderBinding
import com.example.cloneshopee.home.coroutines.dish.CoroutineControlUI
import com.example.cloneshopee.home.viewModels.dish.DishViewModel
import com.squareup.picasso.Picasso
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job

class DisplayOrder: DialogFragment() {
    private lateinit var dishOrderBinding: DishOrderBinding

    private lateinit var dishViewModel: DishViewModel
    private val controlUIJob = Job()
    private val corouScope = CoroutineScope(controlUIJob + Dispatchers.Main)
    val coroutineControlUI = CoroutineControlUI()

    override fun onStart() {
        super.onStart()
        dialog?.window?.setLayout(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        dishOrderBinding = DataBindingUtil.inflate(inflater, R.layout.dish_order,container, false)

        dishViewModel = ViewModelProviders.of(activity!!).get(DishViewModel::class.java)

        uiControl()

        return dishOrderBinding.root
    }

    private fun uiControl(){
        val sharedPreferences = activity!!.getSharedPreferences("CurrentDishOrdered", 0)
        val dishprice = sharedPreferences.getLong("dishprice", 0)

        dishOrderBinding.btnCloseOrder.setOnClickListener {
            dismiss()
        }
        dishViewModel.amount.observe(activity!!, Observer { newAmount ->
            if(newAmount >= 1){
                coroutineControlUI.onCoroutineControllingUI(corouScope, dishOrderBinding, dishViewModel, activity!!)
            }
            dishOrderBinding.txtvOrderAmount.text = newAmount.toString()
            dishOrderBinding.txtvOrderPriceSum.text = (newAmount * dishprice).toString() + "đ"
        })
    }

    override fun onStop() {
        super.onStop()
        coroutineControlUI.onCoroutineDone(controlUIJob)
    }

    override fun onDestroy() {
        super.onDestroy()
        coroutineControlUI.onCoroutineDone(controlUIJob)
    }

}