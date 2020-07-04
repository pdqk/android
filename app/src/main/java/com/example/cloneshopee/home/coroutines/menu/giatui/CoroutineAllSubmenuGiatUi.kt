package com.example.cloneshopee.home.coroutines.menu.giatui

import android.app.Activity
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cloneshopee.databinding.HaveSubmenuLayoutBinding
import com.example.cloneshopee.home.displayMenuSelected.GiatUiActivity
import com.example.cloneshopee.home.models.menuModel.giatuiModel.SubmenuGiatUiModel
import com.example.cloneshopee.home.recyclerViewAdapter.menu.giatui.SubmenuGiatUiAdapter
import com.example.cloneshopee.network.API
import kotlinx.coroutines.*

class CoroutineAllSubmenuGiatUi {
    fun onCoroutineGetSubmenuGiatUi(coroutineScope: CoroutineScope, haveSubmenuLayoutBinding: HaveSubmenuLayoutBinding, activity: Activity, giatUiActivity: GiatUiActivity){
        coroutineScope.launch {
            val getAllSubmenuGiatUiDeffered = API.apiService.getAllSubmenuGiatUi()
            try{
                val listResult = getAllSubmenuGiatUiDeffered.await()
                val len = listResult.size - 1
                val submenuGiatUi = ArrayList<SubmenuGiatUiModel>()
                for(i in 0..len){
                    submenuGiatUi.add(
                        SubmenuGiatUiModel(
                            listResult[i]._id,
                            listResult[i].IMAGE_URL,
                            listResult[i].NAME,
                            listResult[i].PARENT_NAME
                        )
                    )
                }
                haveSubmenuLayoutBinding.recyclerSubmenu.layoutManager = LinearLayoutManager(activity, RecyclerView.HORIZONTAL, false)
                val adapter =
                    SubmenuGiatUiAdapter(
                        submenuGiatUi,
                        giatUiActivity
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