package com.example.cloneshopee.home.coroutines.menu.thucung

import android.app.Activity
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cloneshopee.databinding.HaveSubmenuLayoutBinding
import com.example.cloneshopee.home.displayMenuSelected.ThuCungActivity
import com.example.cloneshopee.home.displayMenuSelected.ThucPhamActivity
import com.example.cloneshopee.home.models.menuModel.thucphamModel.SubmenuThucPhamModel
import com.example.cloneshopee.home.models.menuModel.thucungModel.SubmenuThuCungModel
import com.example.cloneshopee.home.recyclerViewAdapter.menu.thucpham.SubmenuThucPhamAdapter
import com.example.cloneshopee.home.recyclerViewAdapter.menu.thucung.SubmenuThuCungAdapter
import com.example.cloneshopee.network.API
import kotlinx.coroutines.*

class CoroutineAllSubmenuThuCung {
    fun onCoroutineGetSubmenuThuCung(coroutineScope: CoroutineScope, haveSubmenuLayoutBinding: HaveSubmenuLayoutBinding, activity: Activity, thucCungActivity: ThuCungActivity){
        coroutineScope.launch {
            val getAllSubmenuThuCungDeffered = API.apiService.getAllSubmenuThuCung()
            try{
                val listResult = getAllSubmenuThuCungDeffered.await()
                val len = listResult.size - 1
                val submenuThuCung = ArrayList<SubmenuThuCungModel>()
                for(i in 0..len){
                    submenuThuCung.add(
                        SubmenuThuCungModel(
                            listResult[i]._id,
                            listResult[i].IMAGE_URL,
                            listResult[i].NAME,
                            listResult[i].PARENT_NAME
                        )
                    )
                }
                haveSubmenuLayoutBinding.recyclerSubmenu.layoutManager = LinearLayoutManager(activity, RecyclerView.HORIZONTAL, false)
                val adapter =
                    SubmenuThuCungAdapter(
                        submenuThuCung,
                        thucCungActivity
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