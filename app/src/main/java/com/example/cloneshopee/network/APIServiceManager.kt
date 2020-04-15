package com.example.cloneshopee.network

import com.example.cloneshopee.home.models.homepageModel.SlideImageModel
import com.example.cloneshopee.home.models.homepageModel.VoucherModel
import com.example.cloneshopee.home.models.menuModel.thucphamModel.SubmenuThucPhamModel
import com.example.cloneshopee.home.models.menuModel.thucphamModel.ThucPhamSlideImageModel
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.Deferred
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://clone-now.herokuapp.com/api/v1.0/public/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .addCallAdapterFactory(CoroutineCallAdapterFactory())
    .baseUrl(BASE_URL)
    .build()

interface APIService {
    /*Homepage API*/
    @GET("slideimages/all")
    fun getAllSlideImages():
            Deferred<List<SlideImageModel>>

    @GET("vouchers/all")
    fun getAllVouchers():
            Deferred<List<VoucherModel>>

    @GET("thucphams/allSlideImage")
    fun getAllThucPhamSlideImage():
            Deferred<List<ThucPhamSlideImageModel>>

    @GET("submenus/thucpham")
    fun getAllSubmenuThucPham():
            Deferred<List<SubmenuThucPhamModel>>
}

object API {
    val apiService : APIService by lazy {
        retrofit.create(APIService::class.java)
    }
}