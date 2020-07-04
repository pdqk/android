package com.example.cloneshopee.home.coroutines.menu.lamdep

import android.app.Activity
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cloneshopee.databinding.HaveSubmenuLayoutBinding
import com.example.cloneshopee.home.displayMenuSelected.LamDepActivity
import com.example.cloneshopee.home.models.menuModel.lamdepModel.SubmenuLamDepModel
import com.example.cloneshopee.home.recyclerViewAdapter.menu.lamdep.SubmenuLamDepAdapter
import com.example.cloneshopee.network.API
import kotlinx.coroutines.*

class CoroutineAllSubmenuLamDep {
    fun onCoroutineGetSubmenuLamDep(coroutineScope: CoroutineScope, haveSubmenuLayoutBinding: HaveSubmenuLayoutBinding, activity: Activity, lamDepActivity: LamDepActivity){
        coroutineScope.launch {
            val getAllSubmenuLamDepDeffered = API.apiService.getAllSubmenuLamDep()
            try{
                val listResult = getAllSubmenuLamDepDeffered.await()
                val len = listResult.size - 1
                val submenuLamDep = ArrayList<SubmenuLamDepModel>()
                for(i in 0..len){
                    submenuLamDep.add(
                        SubmenuLamDepModel(
                            listResult[i]._id,
                            listResult[i].IMAGE_URL,
                            listResult[i].NAME,
                            listResult[i].PARENT_NAME
                        )
                    )
                }
                haveSubmenuLayoutBinding.recyclerSubmenu.layoutManager = LinearLayoutManager(activity, RecyclerView.HORIZONTAL, false)
                val adapter =
                    SubmenuLamDepAdapter(
                        submenuLamDep,
                        lamDepActivity
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