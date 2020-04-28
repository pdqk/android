package com.example.cloneshopee.home.recyclerViewAdapter.menu.hoa

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
import com.example.cloneshopee.home.displayMenuSelected.HoaActivity
import com.example.cloneshopee.home.models.menuModel.hoaModel.SubmenuHoaModel
import com.example.cloneshopee.home.recyclerViewAdapter.menu.sieuthi.SubmenuSieuThiAdapter
import com.example.cloneshopee.home.viewModels.menu.HoaViewModel
import com.example.cloneshopee.home.viewModels.menu.SieuThiViewModel
import com.squareup.picasso.Picasso

class SubmenuHoaAdapter(val submenuHoaList: ArrayList<SubmenuHoaModel>, val hoaActivity: HoaActivity): RecyclerView.Adapter<SubmenuHoaAdapter.ViewHolder>() {
    var default_index = 0
    private lateinit var hoaViewModel: HoaViewModel

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from((parent?.context)).inflate(R.layout.submenu_recycler_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return submenuHoaList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val submenuHoaModel: SubmenuHoaModel = submenuHoaList[position]
        Picasso.get().load(submenuHoaModel.IMAGE_URL).resize(48,48).centerCrop().into(holder.imgvIcon)
        holder.txtvName?.text = submenuHoaModel.NAME

        holder.itemView.setOnClickListener { view: View ->
            hoaViewModel = ViewModelProviders.of(hoaActivity).get(HoaViewModel::class.java)
            hoaViewModel.onPositionChanged(position)
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


    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val imgvIcon = itemView.findViewById<ImageView>(R.id.imgv_icon_submenu)
        val txtvName = itemView.findViewById<TextView>(R.id.txtv_name_submenu)
        val cvIcon = itemView.findViewById<CardView>(R.id.cardview_submenu)
    }
}