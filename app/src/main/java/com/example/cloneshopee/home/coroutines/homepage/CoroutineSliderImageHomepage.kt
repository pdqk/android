package com.example.cloneshopee.home.coroutines.homepage

import android.app.Activity
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import com.denzcoskun.imageslider.models.SlideModel
import com.example.cloneshopee.databinding.HomePageDisplayBinding
import com.example.cloneshopee.network.API
import com.squareup.picasso.Picasso
import kotlinx.coroutines.*

class CoroutineSliderImageHomepage {
    fun onCoroutineGetSlideImage(coroutineScope: CoroutineScope, activity: FragmentActivity, homePageDisplayBinding: HomePageDisplayBinding){
        coroutineScope.launch {
            var getAllSlideImagesDeferred = API.apiService.getAllSlideImages()
            try{
                var listResult = getAllSlideImagesDeferred.await()
                var len = listResult.size - 1
                var slideModels = ArrayList<SlideModel>()
                for(i in 1..len){
                    slideModels.add(SlideModel(listResult[i].IMAGE_URL))
                }
                homePageDisplayBinding.sliderImage.setImageList(slideModels, true)
                Picasso.get().load(listResult[0].IMAGE_URL).into(homePageDisplayBinding.imgvBannerOnScroll)
            }catch (t: Throwable){
                Toast.makeText(activity, "Failded: " + t, Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun onCoroutineDone(job: Job){
        job.cancel()
    }
}