package com.example.cloneshopee.home.displayHomePage


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cloneshopee.R
import com.example.cloneshopee.databinding.HomePageDisplayBinding
import com.example.cloneshopee.home.coroutines.homepage.CoroutineSliderImageHomepage
import com.example.cloneshopee.home.coroutines.homepage.CoroutineVoucherHomepage
import com.example.cloneshopee.home.models.homepageModel.VoucherModel
import com.example.cloneshopee.home.recyclerViewAdapter.homepage.VoucherAdapter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job

/**
 * A simple [Fragment] subclass.
 */
class FragmentHomePage : Fragment() {
    private lateinit var homePageDisplayBinding: HomePageDisplayBinding

    private var slideImageJob = Job()
    private var voucherJob = Job()
    private var coroutineSlideImageScope = CoroutineScope(slideImageJob + Dispatchers.Main)
    private var coroutineVoucherScope = CoroutineScope(voucherJob + Dispatchers.Main)

    var coroutineSliderImageHomepage = CoroutineSliderImageHomepage()
    var coroutineVoucherHomepage = CoroutineVoucherHomepage()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        homePageDisplayBinding = DataBindingUtil.inflate(inflater, R.layout.home_page_display, container, false)

        setupSliderImage()
        setupVoucher()

        return homePageDisplayBinding.root
    }

    private fun setupSliderImage(){
        coroutineSliderImageHomepage.onCoroutineGetSlideImage(coroutineSlideImageScope, activity!!, homePageDisplayBinding)
    }

    private fun setupVoucher(){
        coroutineVoucherHomepage.onCoroutineGetVoucher(coroutineVoucherScope, homePageDisplayBinding, activity!!)
    }

    override fun onStop() {
        super.onStop()
        coroutineSliderImageHomepage.onCoroutineDone(slideImageJob)
        coroutineVoucherHomepage.onCoroutineDone(voucherJob)
    }
}
