package com.example.cloneshopee.home.displayHomePage


import android.content.Intent
import android.graphics.Color
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
import com.example.cloneshopee.home.displayMenuShop.ThucPhamActivity
import com.example.cloneshopee.home.models.homepageModel.VoucherModel
import com.example.cloneshopee.home.recyclerViewAdapter.homepage.ViewPagerAdapter
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
        setupMenuNavigation()
        setupTabLayouts()

        return homePageDisplayBinding.root
    }

    private fun setupSliderImage(){
        coroutineSliderImageHomepage.onCoroutineGetSlideImage(coroutineSlideImageScope, activity!!, homePageDisplayBinding)
    }

    private fun setupVoucher(){
        coroutineVoucherHomepage.onCoroutineGetVoucher(coroutineVoucherScope, homePageDisplayBinding, activity!!)
    }

    private fun setupTabLayouts(){
        val viewpagerAdapter = ViewPagerAdapter(activity!!.supportFragmentManager)
        homePageDisplayBinding.dontHaveSubmenuInHomepage.viewpagerShared.adapter = viewpagerAdapter
        homePageDisplayBinding.dontHaveSubmenuInHomepage.tabsShared.setupWithViewPager(homePageDisplayBinding.dontHaveSubmenuInHomepage.viewpagerShared)
        homePageDisplayBinding.dontHaveSubmenuInHomepage.tabsShared.setSelectedTabIndicatorColor(
            Color.parseColor("#FF0000")
        )
        homePageDisplayBinding.dontHaveSubmenuInHomepage.tabsShared.setTabTextColors(Color.parseColor("#1d1d1f"), Color.parseColor("#FF0000"))
    }

    private fun setupMenuNavigation(){
        homePageDisplayBinding.imgvThucPham.setOnClickListener { view: View ->
            var intent = Intent(activity, ThucPhamActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onStop() {
        super.onStop()
        coroutineSliderImageHomepage.onCoroutineDone(slideImageJob)
        coroutineVoucherHomepage.onCoroutineDone(voucherJob)
    }

    override fun onDestroy() {
        super.onDestroy()
        coroutineSliderImageHomepage.onCoroutineDone(slideImageJob)
        coroutineVoucherHomepage.onCoroutineDone(voucherJob)
    }
}
