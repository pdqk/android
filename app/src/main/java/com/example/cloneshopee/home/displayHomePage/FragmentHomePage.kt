package com.example.cloneshopee.home.displayHomePage


import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.cloneshopee.R
import com.example.cloneshopee.databinding.HomePageDisplayBinding
import com.example.cloneshopee.home.coroutines.homepage.CoroutineSliderImageHomepage
import com.example.cloneshopee.home.coroutines.homepage.CoroutineVoucherHomepage
import com.example.cloneshopee.home.displayMenuSelected.ThuCungActivity
import com.example.cloneshopee.home.displayMenuSelected.ThucPhamActivity
import com.example.cloneshopee.home.recyclerViewAdapter.homepage.ViewPagerAdapter
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
        val sharedPreferences = activity!!.getSharedPreferences("CurrentSubmenu", 0)
        val editor = sharedPreferences.edit()

        homePageDisplayBinding.imgvThucPham.setOnClickListener { view: View ->
            editor.putString("submenu","thucpham")
            editor.apply()
            editor.commit()
            val intent = Intent(activity, ThucPhamActivity::class.java)
            startActivity(intent)
        }
        homePageDisplayBinding.imgvThuCung.setOnClickListener { view: View ->
            editor.putString("submenu","thucung")
            editor.apply()
            editor.commit()
            val intent = Intent(activity, ThuCungActivity::class.java)
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
