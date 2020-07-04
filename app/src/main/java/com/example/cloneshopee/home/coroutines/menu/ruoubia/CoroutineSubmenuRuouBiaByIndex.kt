package com.example.cloneshopee.home.coroutines.menu.ruoubia

import android.app.Activity
import android.view.View
import android.view.WindowManager
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cloneshopee.databinding.TabsLayoutBinding
import com.example.cloneshopee.home.models.menuModel.ShopModel
import com.example.cloneshopee.home.recyclerViewAdapter.menu.ShopAdapter
import com.example.cloneshopee.network.API
import kotlinx.coroutines.*

class CoroutineSubmenuRuouBiaByIndex {
    fun onCoroutineGetShopOfSubmenuByIndex(coroutineScope: CoroutineScope, tabsLayoutBinding: TabsLayoutBinding, activity: Activity, index: Int?){
        coroutineScope.launch {
            when(index){
                0 -> {
                    val getAllSubmenuBiaDeffered = API.apiService.getAllSubmenuBia()
                    try{
                        tabsLayoutBinding.pbInTablayout.visibility = View.VISIBLE
                        activity.window.setFlags(
                            WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
                            WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE)
                        val listResult = getAllSubmenuBiaDeffered.await()
                        val len = listResult.size - 1
                        val submenuBia = ArrayList<ShopModel>()
                        for(i in 0..len){
                            submenuBia.add(
                                ShopModel(
                                    listResult[i]._id,
                                    listResult[i].IMAGE_URL,
                                    listResult[i].NAME,
                                    listResult[i].ADDRESS,
                                    listResult[i].RATING,
                                    listResult[i].VOUCHER_DESCRIPTION,
                                    listResult[i].SUBMENU_NAME
                                )
                            )
                        }
                        tabsLayoutBinding.recyclerShop.layoutManager = LinearLayoutManager(activity, RecyclerView.VERTICAL, false)
                        val adapter =
                            ShopAdapter(
                                submenuBia
                            )
                        adapter.notifyDataSetChanged()
                        tabsLayoutBinding.pbInTablayout.visibility = View.GONE
                        activity.window.clearFlags(
                            WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE)
                        tabsLayoutBinding.recyclerShop.adapter = adapter
                    }catch (t: Throwable){
                        Toast.makeText(activity, "Failded: " + t, Toast.LENGTH_SHORT).show()
                    }
                }
                1 -> {
                    val getAllSubmenuRuouDeffered = API.apiService.getAllSubmenuRuou()
                    try{
                        tabsLayoutBinding.pbInTablayout.visibility = View.VISIBLE
                        activity.window.setFlags(
                            WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
                            WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE)
                        val listResult = getAllSubmenuRuouDeffered.await()
                        val len = listResult.size - 1
                        val submenuRuou = ArrayList<ShopModel>()
                        for(i in 0..len){
                            submenuRuou.add(
                                ShopModel(
                                    listResult[i]._id,
                                    listResult[i].IMAGE_URL,
                                    listResult[i].NAME,
                                    listResult[i].ADDRESS,
                                    listResult[i].RATING,
                                    listResult[i].VOUCHER_DESCRIPTION,
                                    listResult[i].SUBMENU_NAME
                                )
                            )
                        }
                        tabsLayoutBinding.recyclerShop.layoutManager = LinearLayoutManager(activity, RecyclerView.VERTICAL, false)
                        val adapter =
                            ShopAdapter(
                                submenuRuou
                            )
                        adapter.notifyDataSetChanged()
                        tabsLayoutBinding.pbInTablayout.visibility = View.GONE
                        activity.window.clearFlags(
                            WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE)
                        tabsLayoutBinding.recyclerShop.adapter = adapter
                    }catch (t: Throwable){
                        Toast.makeText(activity, "Failded: " + t, Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }

    fun onCoroutineDone(job: Job){
        job.cancel()
    }
}