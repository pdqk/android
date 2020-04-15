package com.example.cloneshopee.home.coroutines.menu.thucpham

import android.app.Activity
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cloneshopee.databinding.HaveSubmenuLayoutBinding
import com.example.cloneshopee.home.models.menuModel.thucphamModel.SubmenuThucPhamModel
import com.example.cloneshopee.home.recyclerViewAdapter.menu.thucpham.SubmenuThucPhamAdapter
import com.example.cloneshopee.network.API
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class CoroutineSubmenuThucPham {
    fun onCoroutineGetSubmenuThucPham(coroutineScope: CoroutineScope, haveSubmenuLayoutBinding: HaveSubmenuLayoutBinding, activity: Activity){
        coroutineScope.launch {
            var getAllSubmenuThucPhamDeffered = API.apiService.getAllSubmenuThucPham()
            try{
                var listResult = getAllSubmenuThucPhamDeffered.await()
                var len = listResult.size - 1
                var submenuThucPham = ArrayList<SubmenuThucPhamModel>()
                for(i in 0..len){
                    submenuThucPham.add(
                        SubmenuThucPhamModel(
                            listResult[i]._id,
                            listResult[i].IMAGE_URL,
                            listResult[i].NAME,
                            listResult[i].PARENT_NAME
                        )
                    )
                }
                haveSubmenuLayoutBinding.recyclerSubmenu.layoutManager = LinearLayoutManager(activity, RecyclerView.HORIZONTAL, false)
                var adapter =
                    SubmenuThucPhamAdapter(
                        submenuThucPham
                    )
                haveSubmenuLayoutBinding.recyclerSubmenu.adapter = adapter
            }catch (t: Throwable){
                Toast.makeText(activity, "Failded: " + t, Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun onCoroutineDone(job: Job){
        job.cancel()
    }
}