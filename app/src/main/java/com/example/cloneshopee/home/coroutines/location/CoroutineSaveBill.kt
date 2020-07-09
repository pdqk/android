package com.example.cloneshopee.home.coroutines.location

import android.app.Activity
import com.example.cloneshopee.home.models.historyBill.BillModel
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class CoroutineSaveBill {
    fun onCoroutineSavingBill(coroutineScope: CoroutineScope, activity: Activity){
        coroutineScope.launch {
            val sharedPreferences = activity.getSharedPreferences("CurrentUser", 0)
            val currentUser = sharedPreferences.getString("currentuser", "")
            val sharedPreferences2 = activity.getSharedPreferences("CurrentShop", 0)
            val shopname = sharedPreferences2.getString("shopname", "")
            val shopimage = sharedPreferences2.getString("shopimage", "")
            val shopaddress = sharedPreferences2.getString("shopaddress", "")
            val sharedPreferences3 = activity.getSharedPreferences("CurrentBillPrice", 0)
            val billprice = sharedPreferences3.getLong("billprice", 0)

            val sharedPreferences5 = activity.getSharedPreferences("CurrentBillHistory", 0)
            val gson = Gson()
            val json = sharedPreferences5.getString("billList", "")
            val type = object : TypeToken<ArrayList<BillModel>>(){}.type
            val arrBill = gson.fromJson<ArrayList<BillModel>>(json, type)

            if(arrBill.size == 10){
                arrBill.removeAt(0)
                arrBill.add(BillModel(currentUser!!,shopname!!,shopimage!!,shopaddress!!,billprice))
            }else{
                arrBill.add(BillModel(currentUser!!,shopname!!,shopimage!!,shopaddress!!,billprice))
            }

            val gson2 = Gson()
            val json2 = gson2.toJson(arrBill)
            val sharedPreferences4 = activity.getSharedPreferences("CurrentBillHistory", 0)
            val editor = sharedPreferences4.edit()
            editor.putString("billList", json2)
            editor.apply()
            editor.commit()
        }
    }

    fun onDone(job: Job){
        job.cancel()
    }
}