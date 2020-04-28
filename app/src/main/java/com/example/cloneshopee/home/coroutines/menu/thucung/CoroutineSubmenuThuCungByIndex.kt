package com.example.cloneshopee.home.coroutines.menu.thucung

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
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class CoroutineSubmenuThuCungByIndex {
    fun onCoroutineGetShopOfSubmenuByIndex(coroutineScope: CoroutineScope, tabsLayoutBinding: TabsLayoutBinding, activity: Activity, index: Int?) {
        coroutineScope.launch {
            when (index) {
                0 -> {
                    val getAllSubmenuThuCungDeffered = API.apiService.getAllSubmenuThuCungs()
                    try{
                        tabsLayoutBinding.pbInTablayout.visibility = View.VISIBLE
                        activity.window.setFlags(
                            WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
                            WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE)
                        val listResult = getAllSubmenuThuCungDeffered.await()
                        val len = listResult.size - 1
                        val submenuThuCung = ArrayList<ShopModel>()
                        for(i in 0..len){
                            submenuThuCung.add(
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
                                submenuThuCung
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