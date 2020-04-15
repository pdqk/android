package com.example.cloneshopee.home.recyclerViewAdapter.menu.thucpham

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cloneshopee.R
import com.example.cloneshopee.home.models.menuModel.thucphamModel.SubmenuThucPhamModel
import com.squareup.picasso.Picasso

class SubmenuThucPhamAdapter(val submenuThucPhamList: ArrayList<SubmenuThucPhamModel>) : RecyclerView.Adapter<SubmenuThucPhamAdapter.ViewHolder>() {
    override fun getItemCount(): Int {
        return  submenuThucPhamList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val submenuThucPhamModel: SubmenuThucPhamModel = submenuThucPhamList[position]
        Picasso.get().load(submenuThucPhamModel.IMAGE_URL).resize(48,48).centerCrop().into(holder.imgvIcon)
        holder.txtvName?.text = submenuThucPhamModel.NAME
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from((parent?.context)).inflate(R.layout.submenu_recycler_item, parent, false);
        return ViewHolder(
            view
        )
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val imgvIcon = itemView.findViewById<ImageView>(R.id.imgv_icon_submenu)
        val txtvName = itemView.findViewById<TextView>(R.id.txtv_name_submenu)
    }
}