package com.example.cloneshopee.home.models.homepageModel

import com.squareup.moshi.Json

data class SlideImageModel(
    val ID: Int,
    @Json(name = "IMAGE_URL") val IMAGE_URL: String
)