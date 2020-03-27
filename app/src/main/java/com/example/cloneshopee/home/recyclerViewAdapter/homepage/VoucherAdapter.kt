package com.example.cloneshopee.home.recyclerViewAdapter.homepage

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cloneshopee.R
import com.example.cloneshopee.home.models.homepageModel.VoucherModel
import com.squareup.picasso.Picasso

class VoucherAdapter(val voucherList: ArrayList<VoucherModel>) : RecyclerView.Adapter<VoucherAdapter.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from((parent?.context)).inflate(R.layout.voucher_recycler_item, parent, false);
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return voucherList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val voucherModel: VoucherModel = voucherList[position]
        Picasso.get().load(voucherModel.VOUCHER_IMAGE_URL).into(holder.imgvVoucher)
        holder.desVoucher?.text = voucherModel.DESCRIPTION
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val imgvVoucher = itemView.findViewById<ImageView>(R.id.imgv_voucher)
        val desVoucher = itemView.findViewById<TextView>(R.id.txtv_voucher)
    }

}