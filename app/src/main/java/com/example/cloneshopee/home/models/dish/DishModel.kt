package com.example.cloneshopee.home.models.dish

import com.squareup.moshi.Json

data class DishModel (
    val _id: String,
    @Json(name = "SHOP_NAME") val SHOP_NAME: String,
    @Json(name = "DISH_IMAGE_URL") val DISH_IMAGE_URL: String,
    @Json(name = "DISH_NAME") val DISH_NAME: String,
    @Json(name = "DISH_LIKE") val DISH_LIKE: Long,
    @Json(name = "DISH_PRICE") val DISH_PRICE: Long
)
{
    override fun equals(other: Any?): Boolean {

        if(javaClass != other?.javaClass){
            return false
        }

        other as DishModel

        if(_id != other._id){
            return false
        }
        if(SHOP_NAME != other.SHOP_NAME){
            return false
        }
        if(DISH_IMAGE_URL != other.DISH_IMAGE_URL){
            return false
        }
        if(DISH_NAME != other.DISH_NAME){
            return false
        }
        if(DISH_LIKE != other.DISH_LIKE){
            return false
        }
        if(DISH_PRICE != other.DISH_PRICE){
            return false
        }

        return true
    }
}