package com.example.cloneshopee.home.displayLocation


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.cloneshopee.R
import com.example.cloneshopee.databinding.FragmentTinhThanhphoBinding

/**
 * A simple [Fragment] subclass.
 */
class FragmentTinhThanhPho : Fragment() {
    private lateinit var fragmentTinhThanhphoBinding: FragmentTinhThanhphoBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        fragmentTinhThanhphoBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_tinh_thanhpho, container, false)

        return fragmentTinhThanhphoBinding.root
    }


}
