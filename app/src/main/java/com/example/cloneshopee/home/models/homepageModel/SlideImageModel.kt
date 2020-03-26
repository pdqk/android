package com.example.cloneshopee.home.models.homepageModel

import com.squareup.moshi.Json

data class SlideImageModel(
    val _id: String,
    @Json(name = "IMAGE_URL") val IMAGE_URL: String
)