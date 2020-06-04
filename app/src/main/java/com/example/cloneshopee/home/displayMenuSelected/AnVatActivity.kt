package com.example.cloneshopee.home.displayMenuSelected

import android.content.Intent
import android.content.SharedPreferences
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.databinding.DataBindingUtil
import com.example.cloneshopee.R
import com.example.cloneshopee.databinding.BoundOfDontHaveSubmenuBinding
import com.example.cloneshopee.databinding.DontHaveSubmenuLayoutBinding
import com.example.cloneshopee.home.HomeActivity
import com.example.cloneshopee.home.recyclerViewAdapter.homepage.ViewPagerAdapter

class AnVatActivity : AppCompatActivity() {
    private lateinit var boundOfDontHaveSubmenuBinding: BoundOfDontHaveSubmenuBinding
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        boundOfDontHaveSubmenuBinding = DataBindingUtil.setContentView(this, R.layout.bound_of_dont_have_submenu)

        setupTabLayouts()
        buttonControl()
        setTextNameForMenu()

        window.apply {
            clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
            statusBarColor = Color.TRANSPARENT
        }

    }

    private fun setTextNameForMenu(){
        sharedPreferences = getSharedPreferences("CurrentSubmenu",0)
        val menuName = sharedPreferences.getString("submenu","")
        if(menuName.equals("anvat")){
            boundOfDontHaveSubmenuBinding.txtvMenuNameInBound.text = "Ăn Vặt"
        }
    }

    private fun buttonControl(){
        sharedPreferences = getSharedPreferences("CurrentSubmenu",0)
        val editor = sharedPreferences.edit()
        boundOfDontHaveSubmenuBinding.imgvBackToHomepage.setOnClickListener { view: View ->
            val intent = Intent(this, HomeActivity::class.java)
            editor.putString("submenu","thucpham")
            editor.apply()
            editor.commit()
            startActivity(intent)
        }
    }

    private fun setupTabLayouts(){
        val viewpagerAdapter = ViewPagerAdapter(this.supportFragmentManager)
        boundOfDontHaveSubmenuBinding.dontHaveSubmenuInBound.viewpagerShared.adapter = viewpagerAdapter
        boundOfDontHaveSubmenuBinding.dontHaveSubmenuInBound.tabsShared.setupWithViewPager(boundOfDontHaveSubmenuBinding.dontHaveSubmenuInBound.viewpagerShared)
        boundOfDontHaveSubmenuBinding.dontHaveSubmenuInBound.tabsShared.setSelectedTabIndicatorColor(
            Color.parseColor("#FF0000")
        )
        boundOfDontHaveSubmenuBinding.dontHaveSubmenuInBound.tabsShared.setTabTextColors(Color.parseColor("#1d1d1f"), Color.parseColor("#FF0000"))
    }
}
