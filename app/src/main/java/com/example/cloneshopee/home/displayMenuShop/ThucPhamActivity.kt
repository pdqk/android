package com.example.cloneshopee.home.displayMenuShop

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.example.cloneshopee.R
import com.example.cloneshopee.databinding.HaveSubmenuLayoutBinding
import com.example.cloneshopee.home.HomeActivity
import com.example.cloneshopee.home.coroutines.menu.thucpham.CoroutineSlideImageThucPham
import com.example.cloneshopee.home.coroutines.menu.thucpham.CoroutineSubmenuThucPham
import com.example.cloneshopee.home.coroutines.menu.thucpham.CoroutineVoucherThucPham
import com.example.cloneshopee.home.recyclerViewAdapter.homepage.ViewPagerAdapter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job

class ThucPhamActivity : AppCompatActivity() {
    private lateinit var haveSubmenuLayoutBinding: HaveSubmenuLayoutBinding

    private var slideImageJob = Job()
    private var coroutineSlideImageScope = CoroutineScope(slideImageJob + Dispatchers.Main)
    private var voucherJob = Job()
    private var coroutineVoucherScope = CoroutineScope(voucherJob + Dispatchers.Main)
    private var submenuThucPhamJob = Job()
    private var coroutineSubmenuThucPhamScope = CoroutineScope(submenuThucPhamJob + Dispatchers.Main)

    var coroutineSliderImageThucPham =
        CoroutineSlideImageThucPham()
    var coroutineVoucherThucPham =
        CoroutineVoucherThucPham()
    var coroutineSubmenuThucPham =
        CoroutineSubmenuThucPham()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        haveSubmenuLayoutBinding = DataBindingUtil.setContentView(this, R.layout.have_submenu_layout)

        buttonControl()
        setupSliderImage()
        setupVoucher()
        setupSubmenuThucPham()
        setupTabLayouts()
    }

    private fun buttonControl(){
        haveSubmenuLayoutBinding.imgvBackToHomepage.setOnClickListener { view: View ->
            var intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }
    }

    private fun setupTabLayouts(){
        val viewpagerAdapter = ViewPagerAdapter(this.supportFragmentManager)
        haveSubmenuLayoutBinding.dontHaveSubmenuInHaveSubmenu.viewpagerShared.adapter = viewpagerAdapter
        haveSubmenuLayoutBinding.dontHaveSubmenuInHaveSubmenu.tabsShared.setupWithViewPager(haveSubmenuLayoutBinding.dontHaveSubmenuInHaveSubmenu.viewpagerShared)
        haveSubmenuLayoutBinding.dontHaveSubmenuInHaveSubmenu.tabsShared.setSelectedTabIndicatorColor(
            Color.parseColor("#FF0000")
        )
        haveSubmenuLayoutBinding.dontHaveSubmenuInHaveSubmenu.tabsShared.setTabTextColors(Color.parseColor("#1d1d1f"), Color.parseColor("#FF0000"))
    }

    private fun setupSliderImage(){
        coroutineSliderImageThucPham.onCoroutineGetSlideImage(coroutineSlideImageScope, this, haveSubmenuLayoutBinding)
    }

    private fun setupVoucher(){
        coroutineVoucherThucPham.onCoroutineGetVoucher(coroutineVoucherScope, haveSubmenuLayoutBinding, this)
    }

    private fun setupSubmenuThucPham(){
        coroutineSubmenuThucPham.onCoroutineGetSubmenuThucPham(coroutineSubmenuThucPhamScope, haveSubmenuLayoutBinding, this)
    }

    override fun onStop() {
        super.onStop()
        coroutineSliderImageThucPham.onCoroutineDone(slideImageJob)
        coroutineVoucherThucPham.onCoroutineDone(voucherJob)
        coroutineSubmenuThucPham.onCoroutineDone(submenuThucPhamJob)
    }

    override fun onDestroy() {
        super.onDestroy()
        coroutineSliderImageThucPham.onCoroutineDone(slideImageJob)
        coroutineVoucherThucPham.onCoroutineDone(voucherJob)
        coroutineSubmenuThucPham.onCoroutineDone(submenuThucPhamJob)
    }
}
