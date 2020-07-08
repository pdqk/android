package com.example.cloneshopee.home.displayHistory


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.cloneshopee.R
import com.example.cloneshopee.databinding.HistoryDisplayBinding

/**
 * A simple [Fragment] subclass.
 */
class FragmentHistory : Fragment() {
    private lateinit var historyDisplayBinding: HistoryDisplayBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        historyDisplayBinding = DataBindingUtil.inflate(inflater, R.layout.history_display, container, false)

        return historyDisplayBinding.root
    }


}
