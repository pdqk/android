package com.example.cloneshopee.home.models.menuModel.giatuiModel

import com.squareup.moshi.Json

data class GiatUiSlideImageModel (
    val _id: String,
    @Json(name = "IMAGE_URL") val IMAGE_URL: String
)