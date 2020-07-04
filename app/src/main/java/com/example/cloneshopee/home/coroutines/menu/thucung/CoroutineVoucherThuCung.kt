package com.example.cloneshopee.home.coroutines.menu.thucung

import android.app.Activity
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cloneshopee.databinding.HaveSubmenuLayoutBinding
import com.example.cloneshopee.home.models.homepageModel.VoucherModel
import com.example.cloneshopee.home.recyclerViewAdapter.homepage.VoucherAdapter
import com.example.cloneshopee.network.API
import kotlinx.coroutines.*

class CoroutineVoucherThuCung {
    fun onCoroutineGetVoucher(coroutineScope: CoroutineScope, haveSubmenuLayoutBinding: HaveSubmenuLayoutBinding, activity: Activity){
        coroutineScope.launch {
            var getAllVoucherDeffered = API.apiService.getAllVouchers()
            try{
                var listResult = getAllVoucherDeffered.await()
                var len = listResult.size - 1
                var voucher = ArrayList<VoucherModel>()
                for(i in 0..len){
                    voucher.add(VoucherModel(listResult[i]._id,listResult[i].VOUCHER_IMAGE_URL, listResult[i].DESCRIPTION))
                }
                haveSubmenuLayoutBinding.recyclerVouchersInHaveSubmenu.layoutManager = LinearLayoutManager(activity, RecyclerView.HORIZONTAL, false)
                var adapter = VoucherAdapter(voucher)
                haveSubmenuLayoutBinding.recyclerVouchersInHaveSubmenu.adapter = adapter
            }catch (t: Throwable){
                Toast.makeText(activity, "Failded: " + t, Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun onCoroutineDone(job: Job){
        job.cancel()
    }
}