package com.example.cloneshopee.home.coroutines.menu.hoa

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

class CoroutineSubmenuHoaByIndex {
    fun onCoroutineGetShopOfSubmenuByIndex(coroutineScope: CoroutineScope, tabsLayoutBinding: TabsLayoutBinding, activity: Activity, index: Int?){
        coroutineScope.launch {
            when(index){
                0 -> {
                    val getAllSubmenuChucMungDeffered = API.apiService.getAllSubmenuChucMung()
                    try{
                        tabsLayoutBinding.pbInTablayout.visibility = View.VISIBLE
                        activity.window.setFlags(
                            WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
                            WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE)
                        val listResult = getAllSubmenuChucMungDeffered.await()
                        val len = listResult.size - 1
                        val submenuChucMung = ArrayList<ShopModel>()
                        for(i in 0..len){
                            submenuChucMung.add(
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
                                submenuChucMung
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
                    val getAllSubmenuSinhNhatDeffered = API.apiService.getAllSubmenuSinhNhat()
                    try{
                        tabsLayoutBinding.pbInTablayout.visibility = View.VISIBLE
                        activity.window.setFlags(
                            WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
                            WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE)
                        val listResult = getAllSubmenuSinhNhatDeffered.await()
                        val len = listResult.size - 1
                        val submenuSinhNhat = ArrayList<ShopModel>()
                        for(i in 0..len){
                            submenuSinhNhat.add(
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
                                submenuSinhNhat
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
                2 -> {
                    val getAllSubmenuTinhYeuDeffered = API.apiService.getAllSubmenuTinhYeu()
                    try{
                        tabsLayoutBinding.pbInTablayout.visibility = View.VISIBLE
                        activity.window.setFlags(
                            WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
                            WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE)
                        val listResult = getAllSubmenuTinhYeuDeffered.await()
                        val len = listResult.size - 1
                        val submenuTinhYeu = ArrayList<ShopModel>()
                        for(i in 0..len){
                            submenuTinhYeu.add(
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
                                submenuTinhYeu
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
                3 -> {
                    val getAllSubmenuChiaBuonDeffered = API.apiService.getAllSubmenuChiaBuon()
                    try{
                        tabsLayoutBinding.pbInTablayout.visibility = View.VISIBLE
                        activity.window.setFlags(
                            WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
                            WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE)
                        val listResult = getAllSubmenuChiaBuonDeffered.await()
                        val len = listResult.size - 1
                        val submenuChiaBuon = ArrayList<ShopModel>()
                        for(i in 0..len){
                            submenuChiaBuon.add(
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
                                submenuChiaBuon
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
                4 -> {
                    val getAllSubmenuCayCanhDeffered = API.apiService.getAllSubmenuCayCanh()
                    try{
                        tabsLayoutBinding.pbInTablayout.visibility = View.VISIBLE
                        activity.window.setFlags(
                            WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
                            WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE)
                        val listResult = getAllSubmenuCayCanhDeffered.await()
                        val len = listResult.size - 1
                        val submenuCayCanh = ArrayList<ShopModel>()
                        for(i in 0..len){
                            submenuCayCanh.add(
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
                                submenuCayCanh
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