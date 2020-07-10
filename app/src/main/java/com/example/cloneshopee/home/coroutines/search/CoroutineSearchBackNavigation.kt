package com.example.cloneshopee.home.coroutines.search

import android.app.Activity
import android.content.Intent
import com.example.cloneshopee.databinding.DisplaySearchBinding
import com.example.cloneshopee.home.displayMenuSelected.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class CoroutineSearchBackNavigation {

    fun onBackNavigating(coroutineScope: CoroutineScope, activity: Activity, displaySearchBinding: DisplaySearchBinding){
        coroutineScope.launch {
            val sharedPreferences = activity.getSharedPreferences("CurrentSubmenu", 0)
            val submenu = sharedPreferences.getString("submenu", "")

            when(submenu){
                "thucpham" -> {
                    displaySearchBinding.imgvBackToHomepage.setOnClickListener {
                        val intent = Intent(activity, ThucPhamActivity::class.java)
                        activity.startActivity(intent)
                    }
                }
                "giatui" -> {
                    displaySearchBinding.imgvBackToHomepage.setOnClickListener {
                        val intent = Intent(activity, GiatUiActivity::class.java)
                        activity.startActivity(intent)
                    }
                }
                "hoa" -> {
                    displaySearchBinding.imgvBackToHomepage.setOnClickListener {
                        val intent = Intent(activity, HoaActivity::class.java)
                        activity.startActivity(intent)
                    }
                }
                "lamdep" -> {
                    displaySearchBinding.imgvBackToHomepage.setOnClickListener {
                        val intent = Intent(activity, LamDepActivity::class.java)
                        activity.startActivity(intent)
                    }
                }
                "ruoubia" -> {
                    displaySearchBinding.imgvBackToHomepage.setOnClickListener {
                        val intent = Intent(activity, RuouBiaActivity::class.java)
                        activity.startActivity(intent)
                    }
                }
                "sieuthi" -> {
                    displaySearchBinding.imgvBackToHomepage.setOnClickListener {
                        val intent = Intent(activity, SieuThiActivity::class.java)
                        activity.startActivity(intent)
                    }
                }
                "thucung" -> {
                    displaySearchBinding.imgvBackToHomepage.setOnClickListener {
                        val intent = Intent(activity, ThuCungActivity::class.java)
                        activity.startActivity(intent)
                    }
                }
                "thuoc" -> {
                    displaySearchBinding.imgvBackToHomepage.setOnClickListener {
                        val intent = Intent(activity, ThuocActivity::class.java)
                        activity.startActivity(intent)
                    }
                }
            }
        }
    }

    fun onDone(job: Job){
        job.cancel()
    }
}