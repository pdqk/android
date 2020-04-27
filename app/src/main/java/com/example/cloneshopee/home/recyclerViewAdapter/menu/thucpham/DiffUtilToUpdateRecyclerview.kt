package com.example.cloneshopee.home.recyclerViewAdapter.menu.thucpham

import androidx.recyclerview.widget.DiffUtil
import com.example.cloneshopee.home.models.menuModel.ShopModel

class DiffUtilToUpdateRecyclerview(private val oldList: List<ShopModel>, private val newList: List<ShopModel>): DiffUtil.Callback(){
    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList.get(oldItemPosition)._id == newList.get(newItemPosition)._id
    }

    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return newList.size
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList.get(oldItemPosition).equals(newList.get(newItemPosition))
    }

}