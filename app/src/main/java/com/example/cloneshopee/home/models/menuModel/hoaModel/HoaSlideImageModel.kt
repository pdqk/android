package com.example.cloneshopee.home.models.menuModel.hoaModel

import com.squareup.moshi.Json

data class HoaSlideImageModel(
    val _id: String,
    @Json(name = "IMAGE_URL") val IMAGE_URL: String
)
