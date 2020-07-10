package com.example.cloneshopee.home.viewModels.search

import android.app.Activity
import android.util.Log
import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cloneshopee.databinding.DisplaySearch2Binding
import com.example.cloneshopee.home.coroutines.search.ConvertString
import com.example.cloneshopee.home.models.dish.DishModel
import com.example.cloneshopee.home.recyclerViewAdapter.dish.DishAdapter
import com.example.cloneshopee.network.API
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class SearchViewModel2: ViewModel() {
    private val _listDish = MutableLiveData<ArrayList<DishModel>>()

    init {
        _listDish.value = ArrayList()
    }

    fun onCoroutineGetResult(coroutineScope: CoroutineScope, activity: Activity, displaySearch2Binding: DisplaySearch2Binding){
        coroutineScope.launch {
            _listDish.value!!.clear()

            val sharedPreferences = activity.getSharedPreferences("CurrentSubmenu", 0)
            val submenu = sharedPreferences.getString("submenu", "")

            val keyword = displaySearch2Binding.edtSearch.text
            val convertString = ConvertString()
            val newString = convertString.removeAccent(keyword.toString())

            when(submenu){
                "dishes" -> {
                    val getResultDeffered = API.apiService.getDishByName(newString)
                    try{
                        val arrList = getResultDeffered.await()
                        displaySearch2Binding.progressBarInSearch.visibility = View.VISIBLE
                        val len = arrList.size - 1
                        for(i in 0..len){
                            _listDish.value!!.add(
                                DishModel(
                                    arrList[i]._id,
                                    arrList[i].SHOP_NAME,
                                    arrList[i].DISH_IMAGE_URL,
                                    arrList[i].DISH_NAME,
                                    arrList[i].DISH_LIKE,
                                    arrList[i].DISH_PRICE
                                )
                            )
                        }
                        if(_listDish.value!!.isEmpty()){
                            displaySearch2Binding.progressBarInSearch.visibility = View.INVISIBLE
                            displaySearch2Binding.llResult.visibility = View.VISIBLE
                            displaySearch2Binding.recyclerSearchShopResult.layoutManager = LinearLayoutManager(activity, RecyclerView.VERTICAL, false)
                            val adapter = DishAdapter(_listDish.value!!, activity)
                            adapter.notifyDataSetChanged()
                            displaySearch2Binding.recyclerSearchShopResult.adapter = adapter
                        }else{
                            displaySearch2Binding.progressBarInSearch.visibility = View.INVISIBLE
                            displaySearch2Binding.llResult.visibility = View.INVISIBLE
                            displaySearch2Binding.recyclerSearchShopResult.layoutManager = LinearLayoutManager(activity, RecyclerView.VERTICAL, false)
                            val adapter = DishAdapter(_listDish.value!!, activity)
                            adapter.notifyDataSetChanged()
                            displaySearch2Binding.recyclerSearchShopResult.adapter = adapter
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