package com.example.cloneshopee.home.coroutines.dish

import androidx.fragment.app.FragmentActivity
import com.example.cloneshopee.databinding.DishOrderBinding
import com.squareup.picasso.Picasso
import kotlinx.coroutines.*

class CoroutineLoadImage {
    fun onCoroutineLoadImage(coroutineScope: CoroutineScope, activity: FragmentActivity, dishOrderBinding: DishOrderBinding){
        coroutineScope.launch {
            val sharedPreferences = activity.getSharedPreferences("CurrentDishOrdered", 0)
            val dishimage = sharedPreferences.getString("dishimage", "")

            Picasso.get().load(dishimage).resize(110, 110).centerCrop().into(dishOrderBinding.imgvOrderPhoto)
        }
    }

    fun onCoroutineDone(job: Job){
        job.cancel()
    }
}