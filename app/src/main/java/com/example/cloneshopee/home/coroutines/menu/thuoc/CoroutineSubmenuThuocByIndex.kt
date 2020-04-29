package com.example.cloneshopee.home.coroutines.menu.thuoc

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

class CoroutineSubmenuThuocByIndex {
    fun onCoroutineGetShopOfSubmenuByIndex(coroutineScope: CoroutineScope, tabsLayoutBinding: TabsLayoutBinding, activity: Activity, index: Int?){
        coroutineScope.launch {
            when(index){
                0 -> {
                    val getAllSubmenuBCSDeffered = API.apiService.getAllSubmenuBCS()
                    try{
                        tabsLayoutBinding.pbInTablayout.visibility = View.VISIBLE
                        activity.window.setFlags(
                            WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
                            WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE)
                        val listResult = getAllSubmenuBCSDeffered.await()
                        val len = listResult.size - 1
                        val submenuBCS = ArrayList<ShopModel>()
                        for(i in 0..len){
                            submenuBCS.add(
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
                                submenuBCS
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
                    val getAllSubmenuVitaminsDeffered = API.apiService.getAllSubmenuVitamins()
                    try{
                        tabsLayoutBinding.pbInTablayout.visibility = View.VISIBLE
                        activity.window.setFlags(
                            WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
                            WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE)
                        val listResult = getAllSubmenuVitaminsDeffered.await()
                        val len = listResult.size - 1
                        val submenuVitamins = ArrayList<ShopModel>()
                        for(i in 0..len){
                            submenuVitamins.add(
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
                                submenuVitamins
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
                    val getAllSubmenuThuocTayDeffered = API.apiService.getAllSubmenuThuocTay()
                    try{
                        tabsLayoutBinding.pbInTablayout.visibility = View.VISIBLE
                        activity.window.setFlags(
                            WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
                            WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE)
                        val listResult = getAllSubmenuThuocTayDeffered.await()
                        val len = listResult.size - 1
                        val submenuThuocTay = ArrayList<ShopModel>()
                        for(i in 0..len){
                            submenuThuocTay.add(
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
                                submenuThuocTay
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
                    val getAllSubmenuThietBiYTeDeffered = API.apiService.getAllSubmenuThietBiYTe()
                    try{
                        tabsLayoutBinding.pbInTablayout.visibility = View.VISIBLE
                        activity.window.setFlags(
                            WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
                            WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE)
                        val listResult = getAllSubmenuThietBiYTeDeffered.await()
                        val len = listResult.size - 1
                        val submenuThietBiYTe = ArrayList<ShopModel>()
                        for(i in 0..len){
                            submenuThietBiYTe.add(
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
                                submenuThietBiYTe
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
                    val getAllSubmenuKhauTrangDeffered = API.apiService.getAllSubmenuKhauTrang()
                    try{
                        tabsLayoutBinding.pbInTablayout.visibility = View.VISIBLE
                        activity.window.setFlags(
                            WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
                            WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE)
                        val listResult = getAllSubmenuKhauTrangDeffered.await()
                        val len = listResult.size - 1
                        val submenuKhauTrang = ArrayList<ShopModel>()
                        for(i in 0..len){
                            submenuKhauTrang.add(
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
                                submenuKhauTrang
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
                5 -> {
                    val getAllSubmenuKhanCapDeffered = API.apiService.getAllSubmenuKhanCap()
                    try{
                        tabsLayoutBinding.pbInTablayout.visibility = View.VISIBLE
                        activity.window.setFlags(
                            WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
                            WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE)
                        val listResult = getAllSubmenuKhanCapDeffered.await()
                        val len = listResult.size - 1
                        val submenuKhanCap = ArrayList<ShopModel>()
                        for(i in 0..len){
                            submenuKhanCap.add(
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
                                submenuKhanCap
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
                6 -> {
                    val getAllSubmenuHoaMyPhamDeffered = API.apiService.getAllSubmenuHoaMyPham()
                    try{
                        tabsLayoutBinding.pbInTablayout.visibility = View.VISIBLE
                        activity.window.setFlags(
                            WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
                            WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE)
                        val listResult = getAllSubmenuHoaMyPhamDeffered.await()
                        val len = listResult.size - 1
                        val submenuHoaMyPham = ArrayList<ShopModel>()
                        for(i in 0..len){
                            submenuHoaMyPham.add(
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
                                submenuHoaMyPham
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