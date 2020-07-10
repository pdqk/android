package com.example.cloneshopee.home.coroutines.search

import android.app.Activity
import android.content.Intent
import com.example.cloneshopee.databinding.DisplaySearch2Binding
import com.example.cloneshopee.databinding.DisplaySearchBinding
import com.example.cloneshopee.home.HomeActivity
import com.example.cloneshopee.home.displayMenuSelected.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class CoroutineSearchBackNavigation2 {

    fun onBackNavigating(coroutineScope: CoroutineScope, activity: Activity, displaySearch2Binding: DisplaySearch2Binding){
        coroutineScope.launch {
            val sharedPreferences = activity.getSharedPreferences("CurrentSubmenu", 0)
            val submenu = sharedPreferences.getString("submenu", "")

            when(submenu){
                "dishes" -> {
                    displaySearch2Binding.imgvBackToHomepage.setOnClickListener {
                        val intent = Intent(activity, HomeActivity::class.java)
                        val editor = sharedPreferences.edit()
                        editor.putString("submenu","thucpham")
                        editor.apply()
                        editor.commit()
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