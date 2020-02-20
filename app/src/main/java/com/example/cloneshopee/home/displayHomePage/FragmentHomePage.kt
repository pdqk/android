package com.example.cloneshopee.home.displayHomePage


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.cloneshopee.R
import com.example.cloneshopee.databinding.HomePageDisplayBinding

/**
 * A simple [Fragment] subclass.
 */
class FragmentHomePage : Fragment() {
    private lateinit var homePageDisplayBinding: HomePageDisplayBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        homePageDisplayBinding = DataBindingUtil.inflate(inflater, R.layout.home_page_display, container, false)

        return homePageDisplayBinding.root
    }


}
