package com.example.cloneshopee.home.displayMenuSelected

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.databinding.DataBindingUtil
import com.example.cloneshopee.R
import com.example.cloneshopee.databinding.HaveSubmenuLayoutBinding
import com.example.cloneshopee.home.HomeActivity
import com.example.cloneshopee.home.coroutines.menu.lamdep.CoroutineAllSubmenuLamDep
import com.example.cloneshopee.home.coroutines.menu.lamdep.CoroutineSlideImageLamDep
import com.example.cloneshopee.home.coroutines.menu.lamdep.CoroutineVoucherLamDep
import com.example.cloneshopee.home.recyclerViewAdapter.homepage.ViewPagerAdapter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job

class LamDepActivity : AppCompatActivity() {
    private lateinit var haveSubmenuLayoutBinding: HaveSubmenuLayoutBinding

    private var slideImageJob = Job()
    private var coroutineSlideImageScope = CoroutineScope(slideImageJob + Dispatchers.Main)
    private var voucherJob = Job()
    private var coroutineVoucherScope = CoroutineScope(voucherJob + Dispatchers.Main)
    private var submenuLamDepJob = Job()
    private var coroutineSubmenuLamDepScope = CoroutineScope(submenuLamDepJob + Dispatchers.Main)

    var coroutineSlideImageLamDep =
        CoroutineSlideImageLamDep()
    var coroutineVoucherLamDep =
        CoroutineVoucherLamDep()
    var coroutineSubmenuLamDep =
        CoroutineAllSubmenuLamDep()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        haveSubmenuLayoutBinding = DataBindingUtil.setContentView(this, R.layout.have_submenu_layout)

        buttonControl()
        setupTabLayouts()
        setupSliderImage()
        setupVoucher()
        setupSubmenuLamDep()

        window.apply {
            clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
            statusBarColor = Color.TRANSPARENT
        }
    }

    private fun buttonControl(){
        val sharedPreferences = getSharedPreferences("CurrentSubmenu",0)
        val editor = sharedPreferences.edit()
        haveSubmenuLayoutBinding.imgvBackToHomepage.setOnClickListener { view: View ->
            val intent = Intent(this, HomeActivity::class.java)
            editor.putString("submenu", "thucpham")
            editor.apply()
            editor.commit()
            startActivity(intent)
        }
    }

    private fun setupSliderImage(){
        coroutineSlideImageLamDep.onCoroutineGetSlideImage(coroutineSlideImageScope, this, haveSubmenuLayoutBinding)
    }

    private fun setupVoucher(){
        coroutineVoucherLamDep.onCoroutineGetVoucher(coroutineVoucherScope, haveSubmenuLayoutBinding, this)
    }

    private fun setupSubmenuLamDep(){
        coroutineSubmenuLamDep.onCoroutineGetSubmenuLamDep(coroutineSubmenuLamDepScope, haveSubmenuLayoutBinding, this, this)
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

    override fun onStop() {
        super.onStop()
        coroutineSlideImageLamDep.onCoroutineDone(slideImageJob)
        coroutineVoucherLamDep.onCoroutineDone(voucherJob)
        coroutineSubmenuLamDep.onCoroutineDone(submenuLamDepJob)
    }

    override fun onDestroy() {
        super.onDestroy()
        coroutineSlideImageLamDep.onCoroutineDone(slideImageJob)
        coroutineVoucherLamDep.onCoroutineDone(voucherJob)
        coroutineSubmenuLamDep.onCoroutineDone(submenuLamDepJob)
    }
}
