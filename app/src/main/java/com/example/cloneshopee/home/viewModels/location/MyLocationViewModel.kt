package com.example.cloneshopee.home.viewModels.location

import android.app.Activity
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cloneshopee.home.displayLocation.DisplayChooseMyLocation

class MyLocationViewModel: ViewModel() {
    private val _myLocation = MutableLiveData<String>()
    val myLocation : LiveData<String>
        get() = _myLocation

    private val _closeChoose = MutableLiveData<Boolean>()
    val closeChoose : LiveData<Boolean>
        get() = _closeChoose

    init {
        _myLocation.value = ""
        _closeChoose.value = false
    }

    fun onCloseChoose(activity: Activity){
        _closeChoose.value = true
        setupAddress(activity)
    }

    fun onOpenChoose(){
        _closeChoose.value = false
    }

    fun setupQuan(activity: Activity, quan: String){
        val sharedPreferencesQuan = activity.getSharedPreferences("CurrentQuan", 0)
        val editor = sharedPreferencesQuan.edit()
        editor.putString("quan", quan)
        editor.apply()
        editor.commit()
    }

    fun setupPhuong(activity: Activity, phuong: String){
        val sharedPreferencesPhuong = activity.getSharedPreferences("CurrentPhuong", 0)
        val editor = sharedPreferencesPhuong.edit()
        editor.putString("phuong", phuong)
        editor.apply()
        editor.commit()
    }

    fun setupAddress(activity: Activity){
        val sharedPreferencesQuan = activity.getSharedPreferences("CurrentQuan", 0)
        val Quan = sharedPreferencesQuan.getString("quan", "")
        val sharedPreferencesPhuong = activity.getSharedPreferences("CurrentPhuong", 0)
        val Phuong = sharedPreferencesPhuong.getString("phuong", "")
        _myLocation.value = Phuong + ", " + Quan
    }
}