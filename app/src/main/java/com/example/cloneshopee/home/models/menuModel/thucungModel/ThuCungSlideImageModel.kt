package com.example.cloneshopee.home.models.menuModel.thucungModel

import com.squareup.moshi.Json

data class ThuCungSlideImageModel (
    val _id: String,
    @Json(name = "IMAGE_URL") val IMAGE_URL: String
)