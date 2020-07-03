package com.example.cloneshopee.home.recyclerViewAdapter.dish

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.cloneshopee.R
import com.example.cloneshopee.home.displayProducts.DisplayOrder
import com.example.cloneshopee.home.models.dish.DishModel
import com.squareup.picasso.Picasso

class DishAdapter(var dishList: ArrayList<DishModel>, var context: Context) : RecyclerView.Adapter<DishAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from((parent?.context)).inflate(R.layout.dish_recycler_item, parent, false)
        return ViewHolder(
            view
        )
    }

    override fun getItemCount(): Int {
        return dishList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val dishModel = dishList[position]
        Picasso.get().load(dishModel.DISH_IMAGE_URL).resize(110, 110).centerCrop().into(holder.imgvDishPhoto)
        holder.txtvDishName?.text = dishModel.DISH_NAME
        holder.txtvDishLike?.text = dishModel.DISH_LIKE.toString()
        holder.txtvDishPrice?.text = dishModel.DISH_PRICE.toString() + "đ"
        holder.btnAddDishToOrder.setOnClickListener { view: View ->
            val sharedPreferences = context.getSharedPreferences("CurrentDishOrdered",0)
            val editor = sharedPreferences.edit()
            editor.putString("dishname",dishModel.DISH_NAME)
            editor.putString("dishimage",dishModel.DISH_IMAGE_URL)
            editor.putString("dishlike",dishModel.DISH_LIKE.toString())
            editor.putLong("dishprice",dishModel.DISH_PRICE)
            editor.apply()
            editor.commit()
            val fm = (context as FragmentActivity).supportFragmentManager
            val displayOrder = DisplayOrder()
            displayOrder.show(fm, "TAG")
        }
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val imgvDishPhoto = itemView.findViewById<ImageView>(R.id.imgv_dish_photo)
        val txtvDishName = itemView.findViewById<TextView>(R.id.txtv_dish_name)
        val txtvDishLike = itemView.findViewById<TextView>(R.id.txtv_dish_like)
        val txtvDishPrice = itemView.findViewById<TextView>(R.id.txtv_dish_price)
        val btnAddDishToOrder = itemView.findViewById<ImageButton>(R.id.btn_add_dish_to_order)
    }

}