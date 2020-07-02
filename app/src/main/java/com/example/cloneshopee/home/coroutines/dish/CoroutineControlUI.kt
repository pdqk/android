package com.example.cloneshopee.home.coroutines.dish

import android.app.Activity
import androidx.lifecycle.Observer
import com.example.cloneshopee.databinding.DishOrderBinding
import com.example.cloneshopee.home.viewModels.dish.DishViewModel
import com.squareup.picasso.Picasso
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class CoroutineControlUI {
    fun onCoroutineControllingUI(coroutineScope: CoroutineScope, dishOrderBinding: DishOrderBinding, dishViewModel: DishViewModel, activity: Activity){
        coroutineScope.launch {
            val sharedPreferences = activity.getSharedPreferences("CurrentDishOrdered", 0)
            val dishname = sharedPreferences.getString("dishname", "")
            val dishimage = sharedPreferences.getString("dishimage", "")
            val dishlike = sharedPreferences.getString("dishlike", "")
            val dishprice = sharedPreferences.getLong("dishprice", 0)
            dishOrderBinding.txtvOrderName.text = dishname
            dishOrderBinding.txtvOrderLike.text = dishlike
            dishOrderBinding.txtvOrderPrice.text = dishprice.toString() + "đ"
            Picasso.get().load(dishimage).resize(110, 110).centerCrop().into(dishOrderBinding.imgvOrderPhoto)

            dishOrderBinding.btnDesOrder.setOnClickListener {
                dishViewModel.onAmountDec()
            }

            dishOrderBinding.btnIncOrder.setOnClickListener {
                dishViewModel.onAmountInc()
            }
        }
    }

    fun onCoroutineDone(job: Job){
        job.cancel()
    }
}