package com.example.cloneshopee.home.displayProducts

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.example.cloneshopee.R
import com.example.cloneshopee.databinding.DishOrderBinding

class DisplayOrder: DialogFragment() {
    private lateinit var displayOrderBinding: DishOrderBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.dish_order, container, false)

        return view
    }
}