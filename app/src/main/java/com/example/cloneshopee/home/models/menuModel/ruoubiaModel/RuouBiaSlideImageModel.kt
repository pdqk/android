package com.example.cloneshopee.home.models.menuModel.ruoubiaModel

import com.squareup.moshi.Json

data class RuouBiaSlideImageModel(
    val _id: String,
    @Json(name = "IMAGE_URL") val IMAGE_URL: String
)