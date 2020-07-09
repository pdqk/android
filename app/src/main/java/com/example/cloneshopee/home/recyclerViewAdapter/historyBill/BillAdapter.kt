package com.example.cloneshopee.home.recyclerViewAdapter.historyBill

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.cloneshopee.R
import com.example.cloneshopee.home.models.historyBill.BillModel
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.squareup.picasso.Picasso

class BillAdapter(var billList: ArrayList<BillModel>, var activity: FragmentActivity): RecyclerView.Adapter<BillAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent?.context).inflate(R.layout.history_bill_recycler_item, parent,false)
        return ViewHolder(
            view
        )
    }

    override fun getItemCount(): Int {
        return billList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val billModel = billList[position]
        Picasso.get().load(billModel.BILL_SHOP_IMAGE).resize(110, 110).centerCrop().into(holder.imgvPhoto)
        holder.txtvBillShopName?.text = billModel.BILL_SHOP_NAME
        holder.txtvBillShopAddress?.text = billModel.BILL_SHOP_ADRESS
        holder.txtvBillPrice?.text = billModel.BILL_PRICE.toString() + "đ"
        holder.imgvButtonDelete.setOnClickListener {
            billList.removeAt(position)
            notifyDataSetChanged()
            val sharedPreferences = activity.getSharedPreferences("CurrentBillHistory", 0)
            val gson = Gson()
            val json = sharedPreferences.getString("billList", "")
            val type = object : TypeToken<ArrayList<BillModel>>(){}.type
            val arrBill = gson.fromJson<ArrayList<BillModel>>(json, type)
            arrBill.removeAt(position)
            val editor = sharedPreferences.edit()
            val json2 = gson.toJson(arrBill)
            editor.putString("billList", json2)
            editor.apply()
            editor.commit()
        }
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val imgvPhoto = itemView.findViewById<ImageView>(R.id.imgv_bill_photo)
        val txtvBillShopName = itemView.findViewById<TextView>(R.id.txtv_bill_shop_name)
        val txtvBillShopAddress = itemView.findViewById<TextView>(R.id.txtv_bill_shop_address)
        val txtvBillPrice = itemView.findViewById<TextView>(R.id.txtv_bill_price)
        val imgvButtonDelete = itemView.findViewById<ImageButton>(R.id.imgv_delete_bill)
    }

}