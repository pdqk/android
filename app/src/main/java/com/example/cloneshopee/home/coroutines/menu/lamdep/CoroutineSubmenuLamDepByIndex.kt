package com.example.cloneshopee.home.coroutines.menu.lamdep

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

class CoroutineSubmenuLamDepByIndex {
    fun onCoroutineGetShopOfSubmenuByIndex(coroutineScope: CoroutineScope, tabsLayoutBinding: TabsLayoutBinding, activity: Activity, index: Int?){
        coroutineScope.launch {
            when(index){
                0 -> {
                    val getAllSubmenuNailDeffered = API.apiService.getAllSubmenuNail()
                    try{
                        tabsLayoutBinding.pbInTablayout.visibility = View.VISIBLE
                        activity.window.setFlags(
                            WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
                            WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE)
                        val listResult = getAllSubmenuNailDeffered.await()
                        val len = listResult.size - 1
                        val submenuNail = ArrayList<ShopModel>()
                        for(i in 0..len){
                            submenuNail.add(
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
                                submenuNail
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
                    val getAllSubmenuMassageDeffered = API.apiService.getAllSubmenuMassage()
                    try{
                        tabsLayoutBinding.pbInTablayout.visibility = View.VISIBLE
                        activity.window.setFlags(
                            WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
                            WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE)
                        val listResult = getAllSubmenuMassageDeffered.await()
                        val len = listResult.size - 1
                        val submenuMassage = ArrayList<ShopModel>()
                        for(i in 0..len){
                            submenuMassage.add(
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
                                submenuMassage
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
                    val getAllSubmenuTocDeffered = API.apiService.getAllSubmenuToc()
                    try{
                        tabsLayoutBinding.pbInTablayout.visibility = View.VISIBLE
                        activity.window.setFlags(
                            WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
                            WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE)
                        val listResult = getAllSubmenuTocDeffered.await()
                        val len = listResult.size - 1
                        val submenuToc = ArrayList<ShopModel>()
                        for(i in 0..len){
                            submenuToc.add(
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
                                submenuToc
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
                    val getAllSubmenuDaDeffered = API.apiService.getAllSubmenuDa()
                    try{
                        tabsLayoutBinding.pbInTablayout.visibility = View.VISIBLE
                        activity.window.setFlags(
                            WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
                            WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE)
                        val listResult = getAllSubmenuDaDeffered.await()
                        val len = listResult.size - 1
                        val submenuDa = ArrayList<ShopModel>()
                        for(i in 0..len){
                            submenuDa.add(
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
                                submenuDa
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
                    val getAllSubmenuNoiMiDeffered = API.apiService.getAllSubmenuNoiMi()
                    try{
                        tabsLayoutBinding.pbInTablayout.visibility = View.VISIBLE
                        activity.window.setFlags(
                            WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
                            WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE)
                        val listResult = getAllSubmenuNoiMiDeffered.await()
                        val len = listResult.size - 1
                        val submenuNoiMi = ArrayList<ShopModel>()
                        for(i in 0..len){
                            submenuNoiMi.add(
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
                                submenuNoiMi
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
                    val getAllSubmenuTattooDeffered = API.apiService.getAllSubmenuTattoo()
                    try{
                        tabsLayoutBinding.pbInTablayout.visibility = View.VISIBLE
                        activity.window.setFlags(
                            WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
                            WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE)
                        val listResult = getAllSubmenuTattooDeffered.await()
                        val len = listResult.size - 1
                        val submenuTattoo = ArrayList<ShopModel>()
                        for(i in 0..len){
                            submenuTattoo.add(
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
                                submenuTattoo
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
                    val getAllSubmenuNhaKhoaDeffered = API.apiService.getAllSubmenuNhaKhoa()
                    try{
                        tabsLayoutBinding.pbInTablayout.visibility = View.VISIBLE
                        activity.window.setFlags(
                            WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
                            WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE)
                        val listResult = getAllSubmenuNhaKhoaDeffered.await()
                        val len = listResult.size - 1
                        val submenuNhaKhoa = ArrayList<ShopModel>()
                        for(i in 0..len){
                            submenuNhaKhoa.add(
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
                                submenuNhaKhoa
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
                7 -> {
                    val getAllSubmenuMakeUpDeffered = API.apiService.getAllSubmenuMakeUp()
                    try{
                        tabsLayoutBinding.pbInTablayout.visibility = View.VISIBLE
                        activity.window.setFlags(
                            WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
                            WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE)
                        val listResult = getAllSubmenuMakeUpDeffered.await()
                        val len = listResult.size - 1
                        val submenuMakeUp = ArrayList<ShopModel>()
                        for(i in 0..len){
                            submenuMakeUp.add(
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
                                submenuMakeUp
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
                8 -> {
                    val getAllSubmenuPhongKhamDeffered = API.apiService.getAllSubmenuPhongKham()
                    try{
                        tabsLayoutBinding.pbInTablayout.visibility = View.VISIBLE
                        activity.window.setFlags(
                            WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
                            WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE)
                        val listResult = getAllSubmenuPhongKhamDeffered.await()
                        val len = listResult.size - 1
                        val submenuPhongKham = ArrayList<ShopModel>()
                        for(i in 0..len){
                            submenuPhongKham.add(
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
                                submenuPhongKham
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