package com.example.cloneshopee.home.models.menuModel

import com.squareup.moshi.Json

data class ShopModel(
    val _id: String,
    @Json(name = "IMAGE_URL") val IMAGE_URL: String,
    @Json(name = "NAME") val NAME: String,
    @Json(name = "ADDRESS") val ADDRESS: String,
    @Json(name = "RATING") val RATING: Int,
    @Json(name = "VOUCHER_DESCRIPTION") val VOUCHER_DESCRIPTION: String,
    @Json(name = "SUBMENU_NAME") val SUBMENU_NAME: String
)
{
    override fun equals(other: Any?): Boolean {

        if(javaClass != other?.javaClass){
            return false
        }

        other as ShopModel

        if(_id != other._id){
            return false
        }
        if(IMAGE_URL != other.IMAGE_URL){
            return false
        }
        if(NAME != other.NAME){
            return false
        }
        if(ADDRESS != other.ADDRESS){
            return false
        }
        if(RATING != other.RATING){
            return false
        }
        if(VOUCHER_DESCRIPTION != other.VOUCHER_DESCRIPTION){
            return false
        }
        if(SUBMENU_NAME != other.SUBMENU_NAME){
            return false
        }

        return true
    }
}