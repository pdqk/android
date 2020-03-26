package com.example.cloneshopee.home.coroutines

import android.app.Activity
import android.widget.Toast
import com.denzcoskun.imageslider.models.SlideModel
import com.example.cloneshopee.databinding.HomePageDisplayBinding
import com.example.cloneshopee.network.API
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class CoroutineSliderImageHomepage {
    fun onCoroutineGetSlideImage(coroutineScope: CoroutineScope, activity: Activity, homePageDisplayBinding: HomePageDisplayBinding){
        coroutineScope.launch {
            var getAllSlideImagesDeferred = API.apiService.getAllSlideImages()
            try{
                var listResult = getAllSlideImagesDeferred.await()
                var len = listResult.size - 1
                var slideModels = ArrayList<SlideModel>()
                for(i in 0..len){
                    slideModels.add(SlideModel(listResult[i].IMAGE_URL))
                }
                homePageDisplayBinding.sliderImage.setImageList(slideModels, true)
            }catch (t: Throwable){
                Toast.makeText(activity, "Failded: " + t, Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun onCoroutineDone(job: Job){
        job.cancel()
    }
}