package com.example.cloneshopee.home.models.menuModel.thucphamModel

import com.squareup.moshi.Json

data class ThucPhamSlideImageModel(
    val _id: String,
    @Json(name = "IMAGE_URL") val IMAGE_URL: String
)