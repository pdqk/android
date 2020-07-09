package com.example.cloneshopee.home.coroutines.search

import android.app.Activity
import android.content.Intent
import com.example.cloneshopee.databinding.DisplaySearchBinding
import com.example.cloneshopee.home.displayMenuSelected.ThucPhamActivity
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
            }
        }
    }

    fun onDone(job: Job){
        job.cancel()
    }
}