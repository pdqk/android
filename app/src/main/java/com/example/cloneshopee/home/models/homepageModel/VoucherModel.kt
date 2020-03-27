package com.example.cloneshopee.home.models.homepageModel

import com.squareup.moshi.Json

data class VoucherModel(
    val _id: String,
    @Json(name = "VOUCHER_IMAGE_URL") val VOUCHER_IMAGE_URL: String,
    @Json(name = "DESCRIPTION") val DESCRIPTION: String
)