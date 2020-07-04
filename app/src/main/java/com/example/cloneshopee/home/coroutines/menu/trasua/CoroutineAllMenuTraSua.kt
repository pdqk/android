package com.example.cloneshopee.home.coroutines.menu.trasua

import android.app.Activity
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cloneshopee.databinding.TabsLayoutBinding
import com.example.cloneshopee.home.models.menuModel.ShopModel
import com.example.cloneshopee.home.recyclerViewAdapter.menu.ShopAdapter
import com.example.cloneshopee.network.API
import kotlinx.coroutines.*

class CoroutineAllMenuTraSua {
    fun onCoroutineGetAllMenuTraSua(coroutineScope: CoroutineScope, tabsLayoutBinding: TabsLayoutBinding, activity: Activity){
        coroutineScope.launch {
            val getAllMenuTraSuaDeffered = API.apiService.getAllMenuTraSua()
            try{
                val listResult = getAllMenuTraSuaDeffered.await()
                val len = listResult.size - 1
                val menuTraSua = ArrayList<ShopModel>()
                for(i in 0..len){
                    menuTraSua.add(
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
                        menuTraSua
                    )
                adapter.notifyDataSetChanged()
                tabsLayoutBinding.recyclerShop.adapter = adapter
            }catch (t:Throwable){
                Toast.makeText(activity, "Failded: " + t, Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun onCoroutineDone(job: Job){
        job.cancel()
    }
}