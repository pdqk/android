package com.example.cloneshopee.home.models.menuModel.sieuthiModel

import com.squareup.moshi.Json

data class SubmenuSieuThiModel (
    val _id: String,
    @Json(name = "IMAGE_URL") val IMAGE_URL: String,
    @Json(name = "NAME") val NAME: String,
    @Json(name = "PARENT_NAME") val PARENT_NAME: String
)