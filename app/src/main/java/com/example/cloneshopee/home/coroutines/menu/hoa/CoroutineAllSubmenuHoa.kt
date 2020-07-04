package com.example.cloneshopee.home.coroutines.menu.hoa

import android.app.Activity
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cloneshopee.databinding.HaveSubmenuLayoutBinding
import com.example.cloneshopee.home.displayMenuSelected.HoaActivity
import com.example.cloneshopee.home.models.menuModel.hoaModel.SubmenuHoaModel
import com.example.cloneshopee.home.models.menuModel.sieuthiModel.SubmenuSieuThiModel
import com.example.cloneshopee.home.recyclerViewAdapter.menu.hoa.SubmenuHoaAdapter
import com.example.cloneshopee.home.recyclerViewAdapter.menu.sieuthi.SubmenuSieuThiAdapter
import com.example.cloneshopee.network.API
import kotlinx.coroutines.*

class CoroutineAllSubmenuHoa {
    fun onCoroutineGetSubmenuHoa(coroutineScope: CoroutineScope, haveSubmenuLayoutBinding: HaveSubmenuLayoutBinding, activity: Activity, hoaActivity: HoaActivity){
        coroutineScope.launch {
            val getAllSubmenuHoaDeffered = API.apiService.getAllSubmenuHoa()
            try{
                val listResult = getAllSubmenuHoaDeffered.await()
                val len = listResult.size - 1
                val submenuHoa = ArrayList<SubmenuHoaModel>()
                for(i in 0..len){
                    submenuHoa.add(
                        SubmenuHoaModel(
                            listResult[i]._id,
                            listResult[i].IMAGE_URL,
                            listResult[i].NAME,
                            listResult[i].PARENT_NAME
                        )
                    )
                }
                haveSubmenuLayoutBinding.recyclerSubmenu.layoutManager = LinearLayoutManager(activity, RecyclerView.HORIZONTAL, false)
                val adapter =
                    SubmenuHoaAdapter(
                        submenuHoa,
                        hoaActivity
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