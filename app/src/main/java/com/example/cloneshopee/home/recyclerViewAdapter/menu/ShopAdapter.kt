package com.example.cloneshopee.home.recyclerViewAdapter.menu

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cloneshopee.R
import com.example.cloneshopee.home.displayProducts.DishesActivity
import com.example.cloneshopee.home.models.menuModel.ShopModel
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

        holder.itemView.setOnClickListener { view: View ->
            val context = holder.itemView.context
            val sharedPreferences = context.getSharedPreferences("CurrentShop",0)
            val editor = sharedPreferences.edit()
            editor.putString("shopname",shopModel.NAME)
            editor.putString("shopimage",shopModel.IMAGE_URL)
            editor.putString("shopaddress",shopModel.ADDRESS)
            editor.putString("shoprating",shopModel.RATING.toString())
            editor.apply()
            editor.commit()
            val intent = Intent(context, DishesActivity::class.java)
            context.startActivity(intent)
        }
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val imgvPhoto = itemView.findViewById<ImageView>(R.id.imgv_shop_photo)
        val txtvName = itemView.findViewById<TextView>(R.id.txtv_shop_name)
        val txtvAddress = itemView.findViewById<TextView>(R.id.txtv_shop_address)
        val txtvRating = itemView.findViewById<TextView>(R.id.txtv_shop_rating)
        val txtvVoucher = itemView.findViewById<TextView>(R.id.txtv_shop_voucher)
    }
}