package com.example.cloneshopee.home.coroutines.menu.ruoubia

import android.app.Activity
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cloneshopee.databinding.HaveSubmenuLayoutBinding
import com.example.cloneshopee.home.displayMenuSelected.RuouBiaActivity
import com.example.cloneshopee.home.models.menuModel.ruoubiaModel.SubmenuRuouBiaModel
import com.example.cloneshopee.home.recyclerViewAdapter.menu.ruoubia.SubmenuRuouBiaAdapter
import com.example.cloneshopee.network.API
import kotlinx.coroutines.*

class CoroutineAllSubmenuRuouBia {
    fun onCoroutineGetSubmenuRuouBia(coroutineScope: CoroutineScope, haveSubmenuLayoutBinding: HaveSubmenuLayoutBinding, activity: Activity, ruouBiaActivity: RuouBiaActivity){
        coroutineScope.launch {
            val getAllSubmenuRuouBiaDeffered = API.apiService.getAllSubmenuRuouBia()
            try{
                val listResult = getAllSubmenuRuouBiaDeffered.await()
                val len = listResult.size - 1
                val submenuRuouBia = ArrayList<SubmenuRuouBiaModel>()
                for(i in 0..len){
                    submenuRuouBia.add(
                        SubmenuRuouBiaModel(
                            listResult[i]._id,
                            listResult[i].IMAGE_URL,
                            listResult[i].NAME,
                            listResult[i].PARENT_NAME
                        )
                    )
                }
                haveSubmenuLayoutBinding.recyclerSubmenu.layoutManager = LinearLayoutManager(activity, RecyclerView.HORIZONTAL, false)
                val adapter =
                    SubmenuRuouBiaAdapter(
                        submenuRuouBia,
                        ruouBiaActivity
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