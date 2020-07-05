package com.example.cloneshopee.home.recyclerViewAdapter.dish

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.RecyclerView
import com.example.cloneshopee.R
import com.example.cloneshopee.home.models.dish.CartModel
import com.example.cloneshopee.home.viewModels.dish.AllCartPriceViewModel

class CartAdapter(var cartList: ArrayList<CartModel>, var activity: FragmentActivity): RecyclerView.Adapter<CartAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent?.context).inflate(R.layout.cart_recycler_item,parent, false)
        return ViewHolder(
            view
        )
    }

    override fun getItemCount(): Int {
        return cartList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val cartModel = cartList[position]
        holder.txtvCartDishName?.text = cartModel.CART_DISH_NAME
        holder.txtvCartDishPrice?.text = cartModel.CART_DISH_PRICE.toString() + "đ"
        holder.txtvCartDishAmount?.text = "x" + cartModel.CART_DISH_AMOUNT.toString()
        holder.imgvDeleteDishInCart.setOnClickListener {
            val allCartPriceViewModel = ViewModelProviders.of(activity).get(AllCartPriceViewModel::class.java)
            cartList.removeAt(position)
            notifyDataSetChanged()
            allCartPriceViewModel.onSubPrice(activity, (cartModel.CART_DISH_PRICE * cartModel.CART_DISH_AMOUNT))
        }
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val txtvCartDishName = itemView.findViewById<TextView>(R.id.txtv_cart_dish_name)
        val txtvCartDishPrice = itemView.findViewById<TextView>(R.id.txtv_cart_dish_price)
        val txtvCartDishAmount = itemView.findViewById<TextView>(R.id.txtv_cart_dish_amount)
        val imgvDeleteDishInCart = itemView.findViewById<ImageButton>(R.id.imgv_delete_dish_in_cart)
    }

}