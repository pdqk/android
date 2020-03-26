package com.example.cloneshopee.home.displayHomePage


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.denzcoskun.imageslider.models.SlideModel
import com.example.cloneshopee.R
import com.example.cloneshopee.databinding.HomePageDisplayBinding
import com.example.cloneshopee.home.coroutines.CoroutineSliderImageHomepage
import com.example.cloneshopee.home.models.homepageModel.SlideImageModel
import com.example.cloneshopee.network.API
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * A simple [Fragment] subclass.
 */
class FragmentHomePage : Fragment() {
    private lateinit var homePageDisplayBinding: HomePageDisplayBinding

    private var slideImageJob = Job()
    private var coroutineScope = CoroutineScope(slideImageJob + Dispatchers.Main)
    var coroutineSliderImageHomepage = CoroutineSliderImageHomepage()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        homePageDisplayBinding = DataBindingUtil.inflate(inflater, R.layout.home_page_display, container, false)

        setupSliderImage()

        return homePageDisplayBinding.root
    }

    private fun setupSliderImage(){
        coroutineSliderImageHomepage.onCoroutineGetSlideImage(coroutineScope, activity!!, homePageDisplayBinding)
    }

    override fun onStop() {
        super.onStop()
        coroutineSliderImageHomepage.onCoroutineDone(slideImageJob)
    }
}
