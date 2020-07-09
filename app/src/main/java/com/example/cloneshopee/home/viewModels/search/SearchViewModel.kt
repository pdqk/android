package com.example.cloneshopee.home.viewModels.search

import android.app.Activity
import android.util.Log
import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cloneshopee.databinding.DisplaySearchBinding
import com.example.cloneshopee.home.coroutines.search.ConvertString
import com.example.cloneshopee.home.models.menuModel.ShopModel
import com.example.cloneshopee.home.recyclerViewAdapter.menu.ShopAdapter
import com.example.cloneshopee.network.API
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class SearchViewModel: ViewModel() {
    private val _listSearch = MutableLiveData<ArrayList<ShopModel>>()

    init {
        _listSearch.value = ArrayList()
    }

    fun onCoroutineGetResult(coroutineScope: CoroutineScope, activity: Activity, displaySearchBinding: DisplaySearchBinding){
        coroutineScope.launch {
            _listSearch.value!!.clear()

            val sharedPreferences = activity.getSharedPreferences("CurrentSubmenu", 0)
            val submenu = sharedPreferences.getString("submenu", "")

            val keyword = displaySearchBinding.edtSearch.text
            val convertString = ConvertString()
            val newString = convertString.removeAccent(keyword.toString())

            when(submenu){
                "thucpham" -> {
                    val getResultDeffered = API.apiService.getShopThucPhamByName(newString)
                    try{
                        val arrList = getResultDeffered.await()
                        displaySearchBinding.progressBarInSearch.visibility = View.VISIBLE
                        val len = arrList.size - 1
                        for(i in 0..len){
                            _listSearch.value!!.add(
                                ShopModel(
                                    arrList[i]._id,
                                    arrList[i].IMAGE_URL,
                                    arrList[i].NAME,
                                    arrList[i].ADDRESS,
                                    arrList[i].RATING,
                                    arrList[i].VOUCHER_DESCRIPTION,
                                    arrList[i].SUBMENU_NAME
                                )
                            )
                        }
                        if(_listSearch.value!!.isEmpty()){
                            displaySearchBinding.progressBarInSearch.visibility = View.INVISIBLE
                            displaySearchBinding.llResult.visibility = View.VISIBLE
                            displaySearchBinding.recyclerSearchShopResult.layoutManager = LinearLayoutManager(activity, RecyclerView.VERTICAL, false)
                            val adapter = ShopAdapter(_listSearch.value!!)
                            adapter.notifyDataSetChanged()
                            displaySearchBinding.recyclerSearchShopResult.adapter = adapter
                        }else{
                            displaySearchBinding.progressBarInSearch.visibility = View.INVISIBLE
                            displaySearchBinding.llResult.visibility = View.INVISIBLE
                            displaySearchBinding.recyclerSearchShopResult.layoutManager = LinearLayoutManager(activity, RecyclerView.VERTICAL, false)
                            val adapter = ShopAdapter(_listSearch.value!!)
                            adapter.notifyDataSetChanged()
                            displaySearchBinding.recyclerSearchShopResult.adapter = adapter
                        }
                        //Log.i("List", newString)
                    }catch (t: Throwable){
                        Log.e("Error", t.toString())
                    }
                }
            }
        }
    }

    fun onDone(job: Job){
        job.cancel()
    }
}