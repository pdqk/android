package com.example.cloneshopee.home.recyclerViewAdapter.homepage

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.PagerAdapter
import com.example.cloneshopee.home.displayHomePage.FragmentBestSelling
import com.example.cloneshopee.home.displayHomePage.FragmentFastDelivery
import com.example.cloneshopee.home.displayHomePage.FragmentNearByMe
import com.example.cloneshopee.home.displayHomePage.FragmentRating

class ViewPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm){

    override fun getItem(position: Int): Fragment {
        return when(position){
            0 -> { FragmentNearByMe() }
            1 -> { FragmentBestSelling() }
            2 -> { FragmentRating() }
            else -> {
                return FragmentFastDelivery()
            }
        }
    }

    override fun getCount(): Int {
        return 4
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when(position){
            0 -> "Gần tôi"
            1 -> "Bán chạy"
            2 -> "Đánh giá"
            else -> {
                "Giao nhanh"
            }
        }
    }

    override fun getItemPosition(`object`: Any): Int {
        return PagerAdapter.POSITION_NONE
    }
}