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

    var numberOfLimitItem = 5

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from((parent?.context)).inflate(R.layout.voucher_recycler_item, parent, false);
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        if(voucherList.size >= numberOfLimitItem){
            return numberOfLimitItem
        }else{
            return voucherList.size
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val voucherModel: VoucherModel = voucherList[position]
        Picasso.get().load(voucherModel.VOUCHER_IMAGE_URL).resize(100,100).centerCrop().into(holder.imgvVoucher)
        holder.desVoucher?.text = voucherModel.DESCRIPTION
    }

    override fun onViewRecycled(holder: ViewHolder) {
        super.onViewRecycled(holder)
        Picasso.get().cancelRequest(holder.imgvVoucher)
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val imgvVoucher = itemView.findViewById<ImageView>(R.id.imgv_voucher)
        val desVoucher = itemView.findViewById<TextView>(R.id.txtv_voucher)
    }

}