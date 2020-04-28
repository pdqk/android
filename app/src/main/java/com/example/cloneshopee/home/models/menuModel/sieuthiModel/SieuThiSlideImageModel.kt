package com.example.cloneshopee.home.models.menuModel.sieuthiModel

import com.squareup.moshi.Json

data class SieuThiSlideImageModel (
    val _id: String,
    @Json(name = "IMAGE_URL") val IMAGE_URL: String
)