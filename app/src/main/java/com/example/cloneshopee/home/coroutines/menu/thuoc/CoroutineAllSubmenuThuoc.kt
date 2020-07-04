package com.example.cloneshopee.home.coroutines.menu.thuoc

import android.app.Activity
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cloneshopee.databinding.HaveSubmenuLayoutBinding
import com.example.cloneshopee.home.displayMenuSelected.ThuocActivity
import com.example.cloneshopee.home.models.menuModel.thuocModel.SubmenuThuocModel
import com.example.cloneshopee.home.recyclerViewAdapter.menu.thuoc.SubmenuThuocAdapter
import com.example.cloneshopee.network.API
import kotlinx.coroutines.*

class CoroutineAllSubmenuThuoc {
    fun onCoroutineGetSubmenuThuoc(coroutineScope: CoroutineScope, haveSubmenuLayoutBinding: HaveSubmenuLayoutBinding, activity: Activity, thuocActivity: ThuocActivity){
        coroutineScope.launch {
            val getAllSubmenuThuocDeffered = API.apiService.getAllSubmenuThuoc()
            try{
                val listResult = getAllSubmenuThuocDeffered.await()
                val len = listResult.size - 1
                val submenuThuoc = ArrayList<SubmenuThuocModel>()
                for(i in 0..len){
                    submenuThuoc.add(
                        SubmenuThuocModel(
                            listResult[i]._id,
                            listResult[i].IMAGE_URL,
                            listResult[i].NAME,
                            listResult[i].PARENT_NAME
                        )
                    )
                }
                haveSubmenuLayoutBinding.recyclerSubmenu.layoutManager = LinearLayoutManager(activity, RecyclerView.HORIZONTAL, false)
                val adapter =
                    SubmenuThuocAdapter(
                        submenuThuoc,
                        thuocActivity
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