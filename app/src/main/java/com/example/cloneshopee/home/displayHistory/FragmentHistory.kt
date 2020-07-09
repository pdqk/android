package com.example.cloneshopee.home.displayHistory

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.cloneshopee.R
import com.example.cloneshopee.databinding.HistoryDisplayBinding
import com.example.cloneshopee.home.models.historyBill.BillModel
import com.example.cloneshopee.home.recyclerViewAdapter.historyBill.BillAdapter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


/**
 * A simple [Fragment] subclass.
 */
class FragmentHistory : Fragment() {
    private lateinit var historyDisplayBinding: HistoryDisplayBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        historyDisplayBinding = DataBindingUtil.inflate(inflater, R.layout.history_display, container, false)

        getBillHistory()

        return historyDisplayBinding.root
    }

    private fun getBillHistory(){
        val sharedPreferences = activity!!.getSharedPreferences("CurrentBillHistory", 0)
        val gson = Gson()
        val json = sharedPreferences.getString("billList", "")
        val type = object : TypeToken<ArrayList<BillModel>>(){}.type
        val arrBill = gson.fromJson<ArrayList<BillModel>>(json, type)
        if(arrBill.isEmpty()){
            historyDisplayBinding.ll1.visibility = View.VISIBLE
        }else{
            historyDisplayBinding.ll1.visibility = View.INVISIBLE
            val billAdapter = BillAdapter(arrBill, activity!!)
            historyDisplayBinding.recyclerBill.adapter = billAdapter
        }
    }

}
