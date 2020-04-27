package com.example.cloneshopee.home.displayHomePage


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.cloneshopee.R
import com.example.cloneshopee.databinding.TabsLayoutBinding
import com.example.cloneshopee.home.coroutines.menu.thucpham.CoroutineSubmenuByIndex
import com.example.cloneshopee.home.viewModels.menu.ThucPhamViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job

/**
 * A simple [Fragment] subclass.
 */
class FragmentNearByMe : Fragment(){

    private lateinit var tabsLayoutBinding: TabsLayoutBinding
    private lateinit var thucPhamViewModel: ThucPhamViewModel

    private var getShopDacSanJob = Job()
    private var coroutineGetDacSanScope = CoroutineScope(getShopDacSanJob + Dispatchers.Main)
    var coroutineGetShopOfSubmenuThucPhamByIndex = CoroutineSubmenuByIndex()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        tabsLayoutBinding = DataBindingUtil.inflate(inflater, R.layout.tabs_layout, container, false)

        thucPhamViewModel = ViewModelProviders.of(activity!!).get(ThucPhamViewModel::class.java)
        setupSubmenuDacSan()

        return tabsLayoutBinding.root
    }

    private fun setupSubmenuDacSan(){
        var position = thucPhamViewModel.position.value
        thucPhamViewModel.position.observe(activity!!, Observer { newPosition ->
            position = newPosition
            Toast.makeText(activity, ""+position, Toast.LENGTH_SHORT).show()
        })

        coroutineGetShopOfSubmenuThucPhamByIndex.onCoroutineGetShopOfSubmenuByIndex(coroutineGetDacSanScope, tabsLayoutBinding, activity!!, position)
    }

    override fun onDestroy() {
        super.onDestroy()
        coroutineGetShopOfSubmenuThucPhamByIndex.onCoroutineDone(getShopDacSanJob)
    }

}
