package com.example.cloneshopee.home.displayMe


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.cloneshopee.R
import com.example.cloneshopee.databinding.MeDisplayBinding

/**
 * A simple [Fragment] subclass.
 */
class FragmentMe : Fragment() {
    private lateinit var meDisplayBinding: MeDisplayBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        meDisplayBinding = DataBindingUtil.inflate(inflater, R.layout.me_display, container, false)

        return meDisplayBinding.root
    }
}
