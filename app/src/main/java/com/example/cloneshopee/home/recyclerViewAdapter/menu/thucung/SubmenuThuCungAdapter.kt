package com.example.cloneshopee.home.recyclerViewAdapter.menu.thucung

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
import com.example.cloneshopee.home.displayMenuSelected.ThuCungActivity
import com.example.cloneshopee.home.models.menuModel.thucungModel.SubmenuThuCungModel
import com.example.cloneshopee.home.viewModels.menu.ThuCungViewModel
import com.squareup.picasso.Picasso

class SubmenuThuCungAdapter(val submenuThuCungList: ArrayList<SubmenuThuCungModel>, val thuCungActivity: ThuCungActivity): RecyclerView.Adapter<SubmenuThuCungAdapter.ViewHolder>() {
    var default_index = 0
    private lateinit var thuCungViewModel: ThuCungViewModel

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from((parent?.context)).inflate(R.layout.submenu_recycler_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return submenuThuCungList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val submenuThuCungModel: SubmenuThuCungModel = submenuThuCungList[position]
        Picasso.get().load(submenuThuCungModel.IMAGE_URL).resize(48,48).centerCrop().into(holder.imgvIcon)
        holder.txtvName?.text = submenuThuCungModel.NAME

        holder.itemView.setOnClickListener { view: View ->
            thuCungViewModel = ViewModelProviders.of(thuCungActivity).get(ThuCungViewModel::class.java)
            thuCungViewModel.onPositionChanged(position)
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