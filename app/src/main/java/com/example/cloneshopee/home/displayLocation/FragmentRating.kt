package com.example.cloneshopee.home.displayLocation

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.DialogFragment
import com.example.cloneshopee.R
import com.example.cloneshopee.databinding.FragmentRatingBinding
import com.example.cloneshopee.home.HomeActivity

class FragmentRating: DialogFragment() {
    private lateinit var fragmentRatingBinding: FragmentRatingBinding

    override fun onStart() {
        super.onStart()
        dialog?.window?.setLayout(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        fragmentRatingBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_rating, container, false)

        buttonDismissControl()
        buttonRatingControl()

        return fragmentRatingBinding.root
    }

    private fun buttonDismissControl(){
        fragmentRatingBinding.txtvSkip.setOnClickListener {
            dismiss()
            val intent = Intent(activity!!, HomeActivity::class.java)
            startActivity(intent)
        }
    }

    private fun buttonRatingControl(){
        fragmentRatingBinding.txtvDanhGia.setOnClickListener {
            val fm = activity!!.supportFragmentManager
            val fragmentThanks = FragmentThanks()
            fragmentThanks.show(fm, "TAG")
        }
    }
}