package com.example.cloneshopee.home.models.menuModel.lamdepModel

import com.squareup.moshi.Json

data class LamDepSlideImageModel (
    val _id: String,
    @Json(name = "IMAGE_URL") val IMAGE_URL: String
)