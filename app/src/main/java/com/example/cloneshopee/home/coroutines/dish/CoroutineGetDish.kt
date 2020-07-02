package com.example.cloneshopee.home.coroutines.dish

import android.app.Activity
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cloneshopee.databinding.AllDishesOfTheShopBinding
import com.example.cloneshopee.home.models.dish.DishModel
import com.example.cloneshopee.home.recyclerViewAdapter.dish.DishAdapter
import com.example.cloneshopee.network.API
import com.squareup.picasso.Picasso
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class CoroutineGetDish {
    fun onCoroutineGetDish(coroutineScope: CoroutineScope ,activity: Activity, allDishesOfTheShopBinding: AllDishesOfTheShopBinding){
        val sharedPreferences = activity.getSharedPreferences("CurrentSubmenu", 0)
        val submenu = sharedPreferences.getString("submenu", "")

        val sharedPreferences2 = activity.getSharedPreferences("CurrentShop", 0)
        val shopname = sharedPreferences2.getString("shopname", "")
        val shopimage = sharedPreferences2.getString("shopimage", "")
        val shopaddress = sharedPreferences2.getString("shopaddress", "")
        val shoprating = sharedPreferences2.getString("shoprating", "")

        var sumPrice = 0
        var amount = 0

        coroutineScope.launch {
            when(submenu){
                "thucpham" -> {
                    val getDishOfThucPhamDeffered = API.apiService.getDishOfThucPham()
                    try{
                        val listResult = getDishOfThucPhamDeffered.await()
                        val len = listResult.size - 1
                        val dishOfThucPham = ArrayList<DishModel>()
                        for(i in 0..len){
                            if(listResult[i].SHOP_NAME == shopname){
                                dishOfThucPham.add(
                                    DishModel(
                                        listResult[i]._id,
                                        listResult[i].DISH_NAME,
                                        listResult[i].DISH_IMAGE_URL,
                                        listResult[i].DISH_NAME,
                                        listResult[i].DISH_LIKE,
                                        listResult[i].DISH_PRICE
                                    )
                                )
                                amount = amount + 1
                                sumPrice = sumPrice + listResult[i].DISH_PRICE.toInt()
                            }
                        }
                        val averagePrice = sumPrice/amount
                        allDishesOfTheShopBinding.txtvGiaMonTrungBinh.text = "Giá ~ " + averagePrice.toString() +"đ | "
                        Picasso.get().load(shopimage).fit().centerCrop().into(allDishesOfTheShopBinding.imgvShopPhotoDetail)
                        allDishesOfTheShopBinding.txtvShopNameDetail.text = shopname
                        allDishesOfTheShopBinding.txtvShopAddressDetail.text = shopaddress
                        allDishesOfTheShopBinding.txtvShopRatingDetail.text = shoprating

                        allDishesOfTheShopBinding.recyclerDish.layoutManager = LinearLayoutManager(activity, RecyclerView.VERTICAL, false)
                        val adapter = DishAdapter(dishOfThucPham, activity)
                        adapter.notifyDataSetChanged()
                        allDishesOfTheShopBinding.recyclerDish.adapter = adapter
                    }catch (t: Throwable){
                        Toast.makeText(activity, "Failded: " + t, Toast.LENGTH_SHORT).show()
                    }
                }
                "thucung" -> {
                    val getDishOfThuCungDeffered = API.apiService.getDishOfThuCung()
                    try{
                        val listResult = getDishOfThuCungDeffered.await()
                        val len = listResult.size - 1
                        val dishOfThuCung = ArrayList<DishModel>()
                        for(i in 0..len){
                            if(listResult[i].SHOP_NAME == shopname){
                                dishOfThuCung.add(
                                    DishModel(
                                        listResult[i]._id,
                                        listResult[i].DISH_NAME,
                                        listResult[i].DISH_IMAGE_URL,
                                        listResult[i].DISH_NAME,
                                        listResult[i].DISH_LIKE,
                                        listResult[i].DISH_PRICE
                                    )
                                )
                            }
                        }
                        allDishesOfTheShopBinding.recyclerDish.layoutManager = LinearLayoutManager(activity, RecyclerView.VERTICAL, false)
                        val adapter = DishAdapter(dishOfThuCung, activity)
                        adapter.notifyDataSetChanged()
                        allDishesOfTheShopBinding.recyclerDish.adapter = adapter
                    }catch (t: Throwable){
                        Toast.makeText(activity, "Failded: " + t, Toast.LENGTH_SHORT).show()
                    }
                }
                "sieuthi" -> {
                    val getDishOfSieuThiDeffered = API.apiService.getDishOfSieuThi()
                    try{
                        val listResult = getDishOfSieuThiDeffered.await()
                        val len = listResult.size - 1
                        val dishOfSieuThi = ArrayList<DishModel>()
                        for(i in 0..len){
                            if(listResult[i].SHOP_NAME == shopname){
                                dishOfSieuThi.add(
                                    DishModel(
                                        listResult[i]._id,
                                        listResult[i].DISH_NAME,
                                        listResult[i].DISH_IMAGE_URL,
                                        listResult[i].DISH_NAME,
                                        listResult[i].DISH_LIKE,
                                        listResult[i].DISH_PRICE
                                    )
                                )
                            }
                        }
                        allDishesOfTheShopBinding.recyclerDish.layoutManager = LinearLayoutManager(activity, RecyclerView.VERTICAL, false)
                        val adapter = DishAdapter(dishOfSieuThi, activity)
                        adapter.notifyDataSetChanged()
                        allDishesOfTheShopBinding.recyclerDish.adapter = adapter
                    }catch (t: Throwable){
                        Toast.makeText(activity, "Failded: " + t, Toast.LENGTH_SHORT).show()
                    }
                }
                "hoa" -> {
                    val getDishOfHoaDeffered = API.apiService.getDishOfHoa()
                    try{
                        val listResult = getDishOfHoaDeffered.await()
                        val len = listResult.size - 1
                        val dishOfHoa = ArrayList<DishModel>()
                        for(i in 0..len){
                            if(listResult[i].SHOP_NAME == shopname){
                                dishOfHoa.add(
                                    DishModel(
                                        listResult[i]._id,
                                        listResult[i].DISH_NAME,
                                        listResult[i].DISH_IMAGE_URL,
                                        listResult[i].DISH_NAME,
                                        listResult[i].DISH_LIKE,
                                        listResult[i].DISH_PRICE
                                    )
                                )
                            }
                        }
                        allDishesOfTheShopBinding.recyclerDish.layoutManager = LinearLayoutManager(activity, RecyclerView.VERTICAL, false)
                        val adapter = DishAdapter(dishOfHoa, activity)
                        adapter.notifyDataSetChanged()
                        allDishesOfTheShopBinding.recyclerDish.adapter = adapter
                    }catch (t: Throwable){
                        Toast.makeText(activity, "Failded: " + t, Toast.LENGTH_SHORT).show()
                    }
                }
                "ruoubia" -> {
                    val getDishOfRuouBiaDeffered = API.apiService.getDishOfRuouBia()
                    try{
                        val listResult = getDishOfRuouBiaDeffered.await()
                        val len = listResult.size - 1
                        val dishOfRuouBia = ArrayList<DishModel>()
                        for(i in 0..len){
                            if(listResult[i].SHOP_NAME == shopname){
                                dishOfRuouBia.add(
                                    DishModel(
                                        listResult[i]._id,
                                        listResult[i].DISH_NAME,
                                        listResult[i].DISH_IMAGE_URL,
                                        listResult[i].DISH_NAME,
                                        listResult[i].DISH_LIKE,
                                        listResult[i].DISH_PRICE
                                    )
                                )
                            }
                        }
                        allDishesOfTheShopBinding.recyclerDish.layoutManager = LinearLayoutManager(activity, RecyclerView.VERTICAL, false)
                        val adapter = DishAdapter(dishOfRuouBia, activity)
                        adapter.notifyDataSetChanged()
                        allDishesOfTheShopBinding.recyclerDish.adapter = adapter
                    }catch (t: Throwable){
                        Toast.makeText(activity, "Failded: " + t, Toast.LENGTH_SHORT).show()
                    }
                }
                "thuoc" -> {
                    val getDishOfThuocDeffered = API.apiService.getDishOfThuoc()
                    try{
                        val listResult = getDishOfThuocDeffered.await()
                        val len = listResult.size - 1
                        val dishOfThuoc = ArrayList<DishModel>()
                        for(i in 0..len){
                            if(listResult[i].SHOP_NAME == shopname){
                                dishOfThuoc.add(
                                    DishModel(
                                        listResult[i]._id,
                                        listResult[i].DISH_NAME,
                                        listResult[i].DISH_IMAGE_URL,
                                        listResult[i].DISH_NAME,
                                        listResult[i].DISH_LIKE,
                                        listResult[i].DISH_PRICE
                                    )
                                )
                            }
                        }
                        allDishesOfTheShopBinding.recyclerDish.layoutManager = LinearLayoutManager(activity, RecyclerView.VERTICAL, false)
                        val adapter = DishAdapter(dishOfThuoc, activity)
                        adapter.notifyDataSetChanged()
                        allDishesOfTheShopBinding.recyclerDish.adapter = adapter
                    }catch (t: Throwable){
                        Toast.makeText(activity, "Failded: " + t, Toast.LENGTH_SHORT).show()
                    }
                }
                "lamdep" -> {
                    val getDishOfLamDepDeffered = API.apiService.getDishOfLamDep()
                    try{
                        val listResult = getDishOfLamDepDeffered.await()
                        val len = listResult.size - 1
                        val dishOfLamDep = ArrayList<DishModel>()
                        for(i in 0..len){
                            if(listResult[i].SHOP_NAME == shopname){
                                dishOfLamDep.add(
                                    DishModel(
                                        listResult[i]._id,
                                        listResult[i].DISH_NAME,
                                        listResult[i].DISH_IMAGE_URL,
                                        listResult[i].DISH_NAME,
                                        listResult[i].DISH_LIKE,
                                        listResult[i].DISH_PRICE
                                    )
                                )
                            }
                        }
                        allDishesOfTheShopBinding.recyclerDish.layoutManager = LinearLayoutManager(activity, RecyclerView.VERTICAL, false)
                        val adapter = DishAdapter(dishOfLamDep, activity)
                        adapter.notifyDataSetChanged()
                        allDishesOfTheShopBinding.recyclerDish.adapter = adapter
                    }catch (t: Throwable){
                        Toast.makeText(activity, "Failded: " + t, Toast.LENGTH_SHORT).show()
                    }
                }
                "giatui" -> {
                    val getDishOfGiatUiDeffered = API.apiService.getDishOfGiatUi()
                    try{
                        val listResult = getDishOfGiatUiDeffered.await()
                        val len = listResult.size - 1
                        val dishOfGiatUi = ArrayList<DishModel>()
                        for(i in 0..len){
                            if(listResult[i].SHOP_NAME == shopname){
                                dishOfGiatUi.add(
                                    DishModel(
                                        listResult[i]._id,
                                        listResult[i].DISH_NAME,
                                        listResult[i].DISH_IMAGE_URL,
                                        listResult[i].DISH_NAME,
                                        listResult[i].DISH_LIKE,
                                        listResult[i].DISH_PRICE
                                    )
                                )
                            }
                        }
                        allDishesOfTheShopBinding.recyclerDish.layoutManager = LinearLayoutManager(activity, RecyclerView.VERTICAL, false)
                        val adapter = DishAdapter(dishOfGiatUi, activity)
                        adapter.notifyDataSetChanged()
                        allDishesOfTheShopBinding.recyclerDish.adapter = adapter
                    }catch (t: Throwable){
                        Toast.makeText(activity, "Failded: " + t, Toast.LENGTH_SHORT).show()
                    }
                }
                "anvat" -> {
                    val getDishOfAnVatDeffered = API.apiService.getDishOfAnVat()
                    try{
                        val listResult = getDishOfAnVatDeffered.await()
                        val len = listResult.size - 1
                        val dishOfAnVat = ArrayList<DishModel>()
                        for(i in 0..len){
                            if(listResult[i].SHOP_NAME == shopname){
                                dishOfAnVat.add(
                                    DishModel(
                                        listResult[i]._id,
                                        listResult[i].DISH_NAME,
                                        listResult[i].DISH_IMAGE_URL,
                                        listResult[i].DISH_NAME,
                                        listResult[i].DISH_LIKE,
                                        listResult[i].DISH_PRICE
                                    )
                                )
                            }
                        }
                        allDishesOfTheShopBinding.recyclerDish.layoutManager = LinearLayoutManager(activity, RecyclerView.VERTICAL, false)
                        val adapter = DishAdapter(dishOfAnVat, activity)
                        adapter.notifyDataSetChanged()
                        allDishesOfTheShopBinding.recyclerDish.adapter = adapter
                    }catch (t: Throwable){
                        Toast.makeText(activity, "Failded: " + t, Toast.LENGTH_SHORT).show()
                    }
                }
                "trasua" -> {
                    val getDishOfTraSuaDeffered = API.apiService.getDishOfTraSua()
                    try{
                        val listResult = getDishOfTraSuaDeffered.await()
                        val len = listResult.size - 1
                        val dishOfTraSua = ArrayList<DishModel>()
                        for(i in 0..len){
                            if(listResult[i].SHOP_NAME == shopname){
                                dishOfTraSua.add(
                                    DishModel(
                                        listResult[i]._id,
                                        listResult[i].DISH_NAME,
                                        listResult[i].DISH_IMAGE_URL,
                                        listResult[i].DISH_NAME,
                                        listResult[i].DISH_LIKE,
                                        listResult[i].DISH_PRICE
                                    )
                                )
                            }
                        }
                        allDishesOfTheShopBinding.recyclerDish.layoutManager = LinearLayoutManager(activity, RecyclerView.VERTICAL, false)
                        val adapter = DishAdapter(dishOfTraSua, activity)
                        adapter.notifyDataSetChanged()
                        allDishesOfTheShopBinding.recyclerDish.adapter = adapter
                    }catch (t: Throwable){
                        Toast.makeText(activity, "Failded: " + t, Toast.LENGTH_SHORT).show()
                    }
                }
                "com" -> {
                    val getDishOfComDeffered = API.apiService.getDishOfCom()
                    try{
                        val listResult = getDishOfComDeffered.await()
                        val len = listResult.size - 1
                        val dishOfCom = ArrayList<DishModel>()
                        for(i in 0..len){
                            if(listResult[i].SHOP_NAME == shopname){
                                dishOfCom.add(
                                    DishModel(
                                        listResult[i]._id,
                                        listResult[i].DISH_NAME,
                                        listResult[i].DISH_IMAGE_URL,
                                        listResult[i].DISH_NAME,
                                        listResult[i].DISH_LIKE,
                                        listResult[i].DISH_PRICE
                                    )
                                )
                            }
                        }
                        allDishesOfTheShopBinding.recyclerDish.layoutManager = LinearLayoutManager(activity, RecyclerView.VERTICAL, false)
                        val adapter = DishAdapter(dishOfCom, activity)
                        adapter.notifyDataSetChanged()
                        allDishesOfTheShopBinding.recyclerDish.adapter = adapter
                    }catch (t: Throwable){
                        Toast.makeText(activity, "Failded: " + t, Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }

    fun onCoroutineDone(job: Job){
        job.cancel()
    }
}