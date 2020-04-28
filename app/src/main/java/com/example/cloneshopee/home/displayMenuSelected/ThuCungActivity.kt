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
import com.example.cloneshopee.home.coroutines.menu.thucung.CoroutineAllSubmenuThuCung
import com.example.cloneshopee.home.coroutines.menu.thucung.CoroutineSlideImageThuCung
import com.example.cloneshopee.home.coroutines.menu.thucung.CoroutineVoucherThuCung
import com.example.cloneshopee.home.recyclerViewAdapter.homepage.ViewPagerAdapter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job

class ThuCungActivity : AppCompatActivity() {
    private lateinit var haveSubmenuLayoutBinding: HaveSubmenuLayoutBinding

    private var slideImageJob = Job()
    private var coroutineSlideImageScope = CoroutineScope(slideImageJob + Dispatchers.Main)
    private var voucherJob = Job()
    private var coroutineVoucherScope = CoroutineScope(voucherJob + Dispatchers.Main)
    private var submenuThuCungJob = Job()
    private var coroutineSubmenuThuCungScope = CoroutineScope(submenuThuCungJob + Dispatchers.Main)


    var coroutineSliderImageThuCung =
        CoroutineSlideImageThuCung()
    var coroutineVoucherThuCung =
        CoroutineVoucherThuCung()
    var coroutineSubmenuThuCung =
        CoroutineAllSubmenuThuCung()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        haveSubmenuLayoutBinding = DataBindingUtil.setContentView(this, R.layout.have_submenu_layout)

        buttonControl()
        setupSliderImage()
        setupVoucher()
        setupSubmenuThuCung()
        setupTabLayouts()

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
        coroutineSliderImageThuCung.onCoroutineGetSlideImage(coroutineSlideImageScope, this, haveSubmenuLayoutBinding)
    }

    private fun setupVoucher(){
        coroutineVoucherThuCung.onCoroutineGetVoucher(coroutineVoucherScope, haveSubmenuLayoutBinding, this)
    }

    private fun setupSubmenuThuCung(){
        coroutineSubmenuThuCung.onCoroutineGetSubmenuThuCung(coroutineSubmenuThuCungScope, haveSubmenuLayoutBinding, this, this)
    }

    override fun onStop() {
        super.onStop()
        coroutineSliderImageThuCung.onCoroutineDone(slideImageJob)
        coroutineVoucherThuCung.onCoroutineDone(voucherJob)
        coroutineSubmenuThuCung.onCoroutineDone(submenuThuCungJob)
    }

    override fun onDestroy() {
        super.onDestroy()
        coroutineSliderImageThuCung.onCoroutineDone(slideImageJob)
        coroutineVoucherThuCung.onCoroutineDone(voucherJob)
        coroutineSubmenuThuCung.onCoroutineDone(submenuThuCungJob)
    }
}
