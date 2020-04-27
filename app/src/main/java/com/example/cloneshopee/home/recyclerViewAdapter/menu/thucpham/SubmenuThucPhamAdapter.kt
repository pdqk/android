package com.example.cloneshopee.home.recyclerViewAdapter.menu.thucpham

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.RecyclerView
import com.example.cloneshopee.R
import com.example.cloneshopee.home.displayHomePage.FragmentNearByMe
import com.example.cloneshopee.home.displayMenuShop.ThucPhamActivity
import com.example.cloneshopee.home.models.menuModel.thucphamModel.SubmenuThucPhamModel
import com.example.cloneshopee.home.viewModels.menu.ThucPhamViewModel
import com.squareup.picasso.Picasso

class SubmenuThucPhamAdapter(val submenuThucPhamList: ArrayList<SubmenuThucPhamModel>, val thucPhamActivity: ThucPhamActivity) : RecyclerView.Adapter<SubmenuThucPhamAdapter.ViewHolder>() {
    var default_index = 0
    private lateinit var thucPhamViewModel: ThucPhamViewModel

    override fun getItemCount(): Int {
        return  submenuThucPhamList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val submenuThucPhamModel: SubmenuThucPhamModel = submenuThucPhamList[position]
        Picasso.get().load(submenuThucPhamModel.IMAGE_URL).resize(48,48).centerCrop().into(holder.imgvIcon)
        holder.txtvName?.text = submenuThucPhamModel.NAME

        holder.itemView.setOnClickListener { view: View ->
            thucPhamViewModel = ViewModelProviders.of(thucPhamActivity).get(ThucPhamViewModel::class.java)
            thucPhamViewModel.onPositionChanged(position)
            default_index = position
            notifyDataSetChanged()
        }

        if(default_index == position){
            holder.txtvName.setTextColor(Color.parseColor("#FF0000"))
            holder.cvIcon.setCardBackgroundColor(Color.parseColor("#FFC1C1"))
        }else{
            holder.txtvName.setTextColor(Color.parseColor("#1d1d1f"))
            holder.cvIcon.setCardBackgroundColor(Color.parseColor("#FFFFFF"))
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from((parent?.context)).inflate(R.layout.submenu_recycler_item, parent, false);
        return ViewHolder(view)
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val imgvIcon = itemView.findViewById<ImageView>(R.id.imgv_icon_submenu)
        val txtvName = itemView.findViewById<TextView>(R.id.txtv_name_submenu)
        val cvIcon = itemView.findViewById<CardView>(R.id.cardview_submenu)
    }
}