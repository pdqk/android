//package com.example.cloneshopee.home.viewModels.history
//
//import android.app.Activity
//import android.app.Application
//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.ViewModelProvider
//import com.example.cloneshopee.home.displayHistory.BillDAO
//import java.lang.IllegalArgumentException
//
//class BillHistoryViewModelFactory(private val database: BillDAO, private val application: Application) : ViewModelProvider.Factory {
//    @Suppress("uncheck_cast")
//    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
//        if(modelClass.isAssignableFrom(BillHistoryViewModel::class.java)){
//            return BillHistoryViewModel(database, application) as T
//        }
//        throw IllegalArgumentException("Unknow viewmodel class")
//    }
//}