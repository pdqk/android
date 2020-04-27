package com.example.cloneshopee.home.recyclerViewAdapter.menu

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.cloneshopee.R
import com.example.cloneshopee.home.models.menuModel.ShopModel
import com.example.cloneshopee.home.recyclerViewAdapter.menu.thucpham.DiffUtilToUpdateRecyclerview
import com.example.cloneshopee.home.viewModels.menu.ThucPhamViewModel
import com.squareup.picasso.Picasso

class ShopAdapter(var shopList: ArrayList<ShopModel>): RecyclerView.Adapter<ShopAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from((parent?.context)).inflate(R.layout.shop_recycler_item, parent, false)
        return ViewHolder(
            view
        )
    }

    override fun getItemCount(): Int {
        return  shopList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val shopModel: ShopModel = shopList[position]
        Picasso.get().load(shopModel.IMAGE_URL).resize(110, 110).centerCrop().into(holder.imgvPhoto)
        holder.txtvName?.text = shopModel.NAME
        holder.txtvAddress?.text = shopModel.ADDRESS
        holder.txtvRating?.text = shopModel.RATING.toString()
        holder.txtvVoucher?.text = shopModel.VOUCHER_DESCRIPTION
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val imgvPhoto = itemView.findViewById<ImageView>(R.id.imgv_shop_photo)
        val txtvName = itemView.findViewById<TextView>(R.id.txtv_shop_name)
        val txtvAddress = itemView.findViewById<TextView>(R.id.txtv_shop_address)
        val txtvRating = itemView.findViewById<TextView>(R.id.txtv_shop_rating)
        val txtvVoucher = itemView.findViewById<TextView>(R.id.txtv_shop_voucher)
    }

    fun insertNewItem(newList:List<ShopModel>){
        val diffUtilToUpdateRecyclerview = DiffUtilToUpdateRecyclerview(shopList, newList)
        val diffResult = DiffUtil.calculateDiff(diffUtilToUpdateRecyclerview)

        shopList.addAll(newList)
        diffResult.dispatchUpdatesTo(this)
    }

    fun updateItem(newList: ArrayList<ShopModel>){
        val oldList = shopList
        val diffResult: DiffUtil.DiffResult = DiffUtil.calculateDiff(
            DiffUtilToUpdateRecyclerview(
                oldList, newList
            )
        )
        shopList = newList
        diffResult.dispatchUpdatesTo(this)
    }
}