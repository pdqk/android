package com.example.cloneshopee.home.displayLocation

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModelProviders
import com.example.cloneshopee.R
import com.example.cloneshopee.databinding.FragmentThanksBinding
import com.example.cloneshopee.home.HomeActivity
import com.example.cloneshopee.home.viewModels.dish.AllCartPriceViewModel
import com.google.gson.Gson

class FragmentThanks: DialogFragment() {
    private lateinit var fragmentThanksBinding: FragmentThanksBinding

    private lateinit var allCartPriceViewModel: AllCartPriceViewModel

    override fun onStart() {
        super.onStart()
        dialog?.window?.setLayout(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        fragmentThanksBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_thanks, container, false)

        allCartPriceViewModel = ViewModelProviders.of(this).get(AllCartPriceViewModel::class.java)

        buttonControl()

        return fragmentThanksBinding.root
    }

    private fun buttonControl(){
        fragmentThanksBinding.btnThanksOk.setOnClickListener {
            val intent = Intent(activity!!, HomeActivity::class.java)
            allCartPriceViewModel.onClearPrice(activity!!)
            startActivity(intent)
        }
    }
}