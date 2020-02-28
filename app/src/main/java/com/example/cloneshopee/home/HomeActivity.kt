package com.example.cloneshopee.home

import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentTransaction
import androidx.navigation.findNavController
import com.example.cloneshopee.R
import com.example.cloneshopee.databinding.HomeActivityBinding
import com.example.cloneshopee.home.displayHomePage.FragmentHomePage
import com.example.cloneshopee.home.displayMe.FragmentMe

class HomeActivity : AppCompatActivity() {
    private lateinit var homeActivityBinding: HomeActivityBinding
    private lateinit var homePage: FragmentHomePage
    private lateinit var me: FragmentMe

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        homeActivityBinding = DataBindingUtil.setContentView(this, R.layout.home_activity)

        window.apply {
            clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
            statusBarColor = Color.TRANSPARENT
        }

        initView()
        bottomNavControl()
    }

    private fun initView(){
        homePage = FragmentHomePage()
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.myHomeNavHost, homePage)
            .setTransition(FragmentTransaction.TRANSIT_NONE)
            .commit()
    }

    private fun bottomNavControl(){
        homeActivityBinding.bottomNavigationControl.setOnNavigationItemSelectedListener { item ->
            when(item.itemId){
                R.id.nav_to_home_page_display -> {
                    homePage = FragmentHomePage()
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.myHomeNavHost, homePage)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()
                }

                R.id.nav_to_bill_display -> {

                }

                R.id.nav_to_favorite_display -> {

                }

                R.id.nav_to_me_display -> {
                    me = FragmentMe()
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.myHomeNavHost, me)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()
                }
            }

            true
        }
    }
}
