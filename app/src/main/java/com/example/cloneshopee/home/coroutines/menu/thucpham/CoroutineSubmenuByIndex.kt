package com.example.cloneshopee.home.coroutines.menu.thucpham

import android.app.Activity
import android.content.Intent
import android.view.WindowManager
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import androidx.viewpager.widget.ViewPager
import com.example.cloneshopee.databinding.HaveSubmenuLayoutBinding
import com.example.cloneshopee.databinding.TabsLayoutBinding
import com.example.cloneshopee.home.displayHomePage.FragmentNearByMe
import com.example.cloneshopee.home.displayMenuShop.ThucPhamActivity
import com.example.cloneshopee.home.models.menuModel.ShopModel
import com.example.cloneshopee.home.models.menuModel.thucphamModel.SubmenuThucPhamModel
import com.example.cloneshopee.home.recyclerViewAdapter.homepage.ViewPagerAdapter
import com.example.cloneshopee.home.recyclerViewAdapter.menu.ShopAdapter
import com.example.cloneshopee.home.recyclerViewAdapter.menu.thucpham.SubmenuThucPhamAdapter
import com.example.cloneshopee.home.viewModels.menu.ThucPhamViewModel
import com.example.cloneshopee.network.API
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class CoroutineSubmenuByIndex() {
    fun onCoroutineGetShopOfSubmenuByIndex(coroutineScope: CoroutineScope, tabsLayoutBinding: TabsLayoutBinding, activity: Activity, index: Int?){
        coroutineScope.launch {
            when(index){
                0 -> {
                    val getAllSubmenuDacSanDeffered = API.apiService.getAllSubmenuDacSan()
                    try{
                        val listResult = getAllSubmenuDacSanDeffered.await()
                        val len = listResult.size - 1
                        val submenuDacSan = ArrayList<ShopModel>()
                        for(i in 0..len){
                            submenuDacSan.add(
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
                                submenuDacSan
                            )
                        adapter.notifyDataSetChanged()
                        tabsLayoutBinding.recyclerShop.adapter = adapter
                    }catch (t: Throwable){
                        Toast.makeText(activity, "Failded: " + t, Toast.LENGTH_SHORT).show()
                    }
                }
                1 -> {
                    val getAllSubmenuAnChayDeffered = API.apiService.getAllSubmenuAnChay()
                    try{
                        val listResult = getAllSubmenuAnChayDeffered.await()
                        val len = listResult.size - 1
                        val submenuAnChay = ArrayList<ShopModel>()
                        for(i in 0..len){
                            submenuAnChay.add(
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
                                submenuAnChay
                            )
                        adapter.notifyDataSetChanged()
                        tabsLayoutBinding.recyclerShop.adapter = adapter
                    }catch (t: Throwable){
                        Toast.makeText(activity, "Failded: " + t, Toast.LENGTH_SHORT).show()
                    }
                }
                2 -> {
                    val getAllSubmenuTraiCayDeffered = API.apiService.getAllSubmenuTraiCay()
                    try{
                        val listResult = getAllSubmenuTraiCayDeffered.await()
                        val len = listResult.size - 1
                        val submenuTraiCay = ArrayList<ShopModel>()
                        for(i in 0..len){
                            submenuTraiCay.add(
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
                                submenuTraiCay
                            )
                        adapter.notifyDataSetChanged()
                        tabsLayoutBinding.recyclerShop.adapter = adapter
                    }catch (t: Throwable){
                        Toast.makeText(activity, "Failded: " + t, Toast.LENGTH_SHORT).show()
                    }
                }
                3 -> {
                    val getAllSubmenuHaiSanDeffered = API.apiService.getAllSubmenuHaiSan()
                    try{
                        val listResult = getAllSubmenuHaiSanDeffered.await()
                        val len = listResult.size - 1
                        val submenuHaiSan = ArrayList<ShopModel>()
                        for(i in 0..len){
                            submenuHaiSan.add(
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
                                submenuHaiSan
                            )
                        adapter.notifyDataSetChanged()
                        tabsLayoutBinding.recyclerShop.adapter = adapter
                    }catch (t: Throwable){
                        Toast.makeText(activity, "Failded: " + t, Toast.LENGTH_SHORT).show()
                    }
                }
                4 -> {
                    val getAllSubmenuRauCuDeffered = API.apiService.getAllSubmenuRauCu()
                    try{
                        val listResult = getAllSubmenuRauCuDeffered.await()
                        val len = listResult.size - 1
                        val submenuRauCu = ArrayList<ShopModel>()
                        for(i in 0..len){
                            submenuRauCu.add(
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
                                submenuRauCu
                            )
                        adapter.notifyDataSetChanged()
                        tabsLayoutBinding.recyclerShop.adapter = adapter
                    }catch (t: Throwable){
                        Toast.makeText(activity, "Failded: " + t, Toast.LENGTH_SHORT).show()
                    }
                }
                5 -> {
                    val getAllSubmenuDoUongAnVatDeffered = API.apiService.getAllSubmenuDoUongAnVat()
                    try{
                        val listResult = getAllSubmenuDoUongAnVatDeffered.await()
                        val len = listResult.size - 1
                        val submenuDoUongAnVat = ArrayList<ShopModel>()
                        for(i in 0..len){
                            submenuDoUongAnVat.add(
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
                                submenuDoUongAnVat
                            )
                        adapter.notifyDataSetChanged()
                        tabsLayoutBinding.recyclerShop.adapter = adapter
                    }catch (t: Throwable){
                        Toast.makeText(activity, "Failded: " + t, Toast.LENGTH_SHORT).show()
                    }
                }
                6 -> {
                    val getAllSubmenuGiaViDeffered = API.apiService.getAllSubmenuGiaVi()
                    try{
                        val listResult = getAllSubmenuGiaViDeffered.await()
                        val len = listResult.size - 1
                        val submenuGiaVi = ArrayList<ShopModel>()
                        for(i in 0..len){
                            submenuGiaVi.add(
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
                                submenuGiaVi
                            )
                        adapter.notifyDataSetChanged()
                        tabsLayoutBinding.recyclerShop.adapter = adapter
                    }catch (t: Throwable){
                        Toast.makeText(activity, "Failded: " + t, Toast.LENGTH_SHORT).show()
                    }
                }
                7 -> {
                    val getAllSubmenuGaoMiDeffered = API.apiService.getAllSubmenuGaoMi()
                    try{
                        val listResult = getAllSubmenuGaoMiDeffered.await()
                        val len = listResult.size - 1
                        val submenuGaoMi = ArrayList<ShopModel>()
                        for(i in 0..len){
                            submenuGaoMi.add(
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
                                submenuGaoMi
                            )
                        adapter.notifyDataSetChanged()
                        tabsLayoutBinding.recyclerShop.adapter = adapter
                    }catch (t: Throwable){
                        Toast.makeText(activity, "Failded: " + t, Toast.LENGTH_SHORT).show()
                    }
                }
                8 -> {
                    val getAllSubmenuThitTrungDeffered = API.apiService.getAllSubmenuThitTrung()
                    try{
                        val listResult = getAllSubmenuThitTrungDeffered.await()
                        val len = listResult.size - 1
                        val submenuThitTrung = ArrayList<ShopModel>()
                        for(i in 0..len){
                            submenuThitTrung.add(
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
                                submenuThitTrung
                            )
                        adapter.notifyDataSetChanged()
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