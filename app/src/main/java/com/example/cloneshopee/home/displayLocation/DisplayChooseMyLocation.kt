package com.example.cloneshopee.home.displayLocation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.DialogFragment
import com.example.cloneshopee.R
import com.example.cloneshopee.databinding.ChooseMyLocationBinding

class DisplayChooseMyLocation: DialogFragment() {
    private lateinit var chooseMyLocationBinding: ChooseMyLocationBinding

    override fun onStart() {
        super.onStart()
        dialog?.window?.setLayout(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        chooseMyLocationBinding = DataBindingUtil.inflate(inflater, R.layout.choose_my_location, container, false)

        closeChooseMyLocation()

        return chooseMyLocationBinding.root
    }

    private fun closeChooseMyLocation(){
        chooseMyLocationBinding.btnCloseChooseMyLocation.setOnClickListener {
            dismiss()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        val fragment = fragmentManager?.findFragmentById(R.id.myNavHostLocation)
        val fragmentTransaction = activity!!.supportFragmentManager.beginTransaction()
        fragmentTransaction.remove(fragment!!)
        fragmentTransaction.commit()
    }
}