package com.example.cloneshopee.home.displayHomePage


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.cloneshopee.R
import com.example.cloneshopee.databinding.TabsLayoutBinding

/**
 * A simple [Fragment] subclass.
 */
class FragmentFastDelivery : Fragment() {
    private lateinit var tabsLayoutBinding: TabsLayoutBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        tabsLayoutBinding = DataBindingUtil.inflate(inflater, R.layout.tabs_layout, container, false)

        return tabsLayoutBinding.root
    }


}
