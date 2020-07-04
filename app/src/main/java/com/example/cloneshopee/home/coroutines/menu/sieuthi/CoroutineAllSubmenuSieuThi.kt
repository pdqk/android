package com.example.cloneshopee.home.coroutines.menu.sieuthi

import android.app.Activity
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cloneshopee.databinding.HaveSubmenuLayoutBinding
import com.example.cloneshopee.home.displayMenuSelected.SieuThiActivity
import com.example.cloneshopee.home.displayMenuSelected.ThuCungActivity
import com.example.cloneshopee.home.models.menuModel.sieuthiModel.SubmenuSieuThiModel
import com.example.cloneshopee.home.models.menuModel.thucungModel.SubmenuThuCungModel
import com.example.cloneshopee.home.recyclerViewAdapter.menu.sieuthi.SubmenuSieuThiAdapter
import com.example.cloneshopee.home.recyclerViewAdapter.menu.thucung.SubmenuThuCungAdapter
import com.example.cloneshopee.network.API
import kotlinx.coroutines.*

class CoroutineAllSubmenuSieuThi {
    fun onCoroutineGetSubmenuSieuThi(coroutineScope: CoroutineScope, haveSubmenuLayoutBinding: HaveSubmenuLayoutBinding, activity: Activity, sieuThiActivity: SieuThiActivity){
        coroutineScope.launch {
            val getAllSubmenuSieuThiDeffered = API.apiService.getAllSubmenuSieuThi()
            try{
                val listResult = getAllSubmenuSieuThiDeffered.await()
                val len = listResult.size - 1
                val submenuSieuThi = ArrayList<SubmenuSieuThiModel>()
                for(i in 0..len){
                    submenuSieuThi.add(
                        SubmenuSieuThiModel(
                            listResult[i]._id,
                            listResult[i].IMAGE_URL,
                            listResult[i].NAME,
                            listResult[i].PARENT_NAME
                        )
                    )
                }
                haveSubmenuLayoutBinding.recyclerSubmenu.layoutManager = LinearLayoutManager(activity, RecyclerView.HORIZONTAL, false)
                val adapter =
                    SubmenuSieuThiAdapter(
                        submenuSieuThi,
                        sieuThiActivity
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