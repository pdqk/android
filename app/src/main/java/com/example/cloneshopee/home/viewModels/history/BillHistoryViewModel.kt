//package com.example.cloneshopee.home.viewModels.history
//
//import android.app.Activity
//import android.app.Application
//import android.util.Log
//import androidx.lifecycle.AndroidViewModel
//import androidx.lifecycle.LiveData
//import androidx.lifecycle.MutableLiveData
//import com.example.cloneshopee.home.displayHistory.BillDAO
//import com.example.cloneshopee.home.models.historyBill.BillModel
//import kotlinx.coroutines.*
//
//class BillHistoryViewModel(val database: BillDAO, application: Application): AndroidViewModel(application) {
//    private val _listBill = MutableLiveData<ArrayList<BillModel>>()
//    val listBill: LiveData<ArrayList<BillModel>>
//        get() = _listBill
//
//    init {
//        _listBill.value = ArrayList()
//    }
//
//    val billJob = Job()
//    val coroutineBillScope = CoroutineScope(billJob + Dispatchers.Main)
//
//    fun insertBillToDB(activity: Activity){
//        coroutineBillScope.launch {
//            insert(activity)
//        }
//    }
//
//    fun getBillFromDB(activity: Activity){
//        coroutineBillScope.launch {
//            _listBill.value!!.add(get(activity))
//            Log.i("test", _listBill.value.toString())
//        }
//    }
//
//    private suspend fun get(activity: Activity): BillModel{
//        val sharedPreferences = activity.getSharedPreferences("CurrentUser", 0)
//        val currentUser = sharedPreferences.getString("currentuser", "")
//        return withContext(Dispatchers.IO){
//            database.getBill(currentUser!!)
//        }
//    }
//
//    private suspend fun insert(activity: Activity){
//        val sharedPreferences = activity.getSharedPreferences("CurrentUser", 0)
//        val currentUser = sharedPreferences.getString("currentuser", "")
//        val sharedPreferences2 = activity.getSharedPreferences("CurrentShop", 0)
//        val shopname = sharedPreferences2.getString("shopname", "")
//        val shopimage = sharedPreferences2.getString("shopimage", "")
//        val shopaddress = sharedPreferences2.getString("shopaddress", "")
//        val sharedPreferences3 = activity.getSharedPreferences("CurrentBillPrice", 0)
//        val billprice = sharedPreferences3.getLong("billprice", 0)
//
//        val billModel = BillModel(0, currentUser!!, shopname!!, shopimage!!, shopaddress!!, billprice)
//        withContext(Dispatchers.IO){
//            database.insertBill(billModel)
//        }
//    }
//}