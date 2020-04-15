package com.example.cloneshopee.home.coroutines.menu.thucpham

import android.app.Activity
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import com.denzcoskun.imageslider.models.SlideModel
import com.example.cloneshopee.databinding.HaveSubmenuLayoutBinding
import com.example.cloneshopee.databinding.HomePageDisplayBinding
import com.example.cloneshopee.network.API
import com.squareup.picasso.Picasso
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class CoroutineSlideImageThucPham {
    fun onCoroutineGetSlideImage(coroutineScope: CoroutineScope, activity: Activity, haveSubmenuLayoutBinding: HaveSubmenuLayoutBinding){
        coroutineScope.launch {
            var getAllSlideImagesDeferred = API.apiService.getAllThucPhamSlideImage()
            try{
                var listResult = getAllSlideImagesDeferred.await()
                var len = listResult.size - 1
                var slideModels = ArrayList<SlideModel>()
                for(i in 0..len){
                    slideModels.add(SlideModel(listResult[i].IMAGE_URL))
                }
                haveSubmenuLayoutBinding.sliderImageInHaveSubmenu.setImageList(slideModels, true)
                Picasso.get().load(listResult[0].IMAGE_URL).into(haveSubmenuLayoutBinding.imgvBannerOnScroll)
            }catch (t: Throwable){
                Toast.makeText(activity, "Failded: " + t, Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun onCoroutineDone(job: Job){
        job.cancel()
    }
}