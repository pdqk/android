package com.example.cloneshopee.home.models.menuModel.thuocModel

import com.squareup.moshi.Json

data class ThuocSlideImageModel (
    val _id: String,
    @Json(name = "IMAGE_URL") val IMAGE_URL: String
)