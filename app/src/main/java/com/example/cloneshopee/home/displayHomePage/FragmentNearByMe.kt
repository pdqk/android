package com.example.cloneshopee.home.displayHomePage


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.cloneshopee.R
import com.example.cloneshopee.databinding.TabsLayoutBinding
import com.example.cloneshopee.home.coroutines.menu.sieuthi.CoroutineSubmenuSieuThiByIndex
import com.example.cloneshopee.home.coroutines.menu.thucpham.CoroutineSubmenuByIndex
import com.example.cloneshopee.home.coroutines.menu.thucung.CoroutineSubmenuThuCungByIndex
import com.example.cloneshopee.home.viewModels.menu.SieuThiViewModel
import com.example.cloneshopee.home.viewModels.menu.ThuCungViewModel
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
    private lateinit var thuCungViewModel: ThuCungViewModel
    private lateinit var sieuThiViewModel: SieuThiViewModel

    private var getShopThucPhamJob = Job()
    private var coroutineGetDacSanScope = CoroutineScope(getShopThucPhamJob + Dispatchers.Main)
    var coroutineGetShopOfSubmenuThucPhamByIndex = CoroutineSubmenuByIndex()

    private var getShopThuCungJob = Job()
    private var coroutineGetThuCungScope = CoroutineScope(getShopThuCungJob + Dispatchers.Main)
    var coroutineGetShopOfSubmenuThuCungByIndex = CoroutineSubmenuThuCungByIndex()

    private var getShopSieuThiJob = Job()
    private var coroutineGetSieuThiScope = CoroutineScope(getShopSieuThiJob + Dispatchers.Main)
    var coroutineGetShopOfSubmenuSieuThiByIndex = CoroutineSubmenuSieuThiByIndex()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        tabsLayoutBinding = DataBindingUtil.inflate(inflater, R.layout.tabs_layout, container, false)

        thucPhamViewModel = ViewModelProviders.of(activity!!).get(ThucPhamViewModel::class.java)
        thuCungViewModel = ViewModelProviders.of(activity!!).get(ThuCungViewModel::class.java)
        sieuThiViewModel = ViewModelProviders.of(activity!!).get(SieuThiViewModel::class.java)

        setupSubmenu()

        return tabsLayoutBinding.root
    }

    private fun setupSubmenu(){
        val sharedPreferences = activity!!.getSharedPreferences("CurrentSubmenu", 0)
        val submenu = sharedPreferences.getString("submenu", "")
            if(submenu == "thucpham"){
                thucPhamViewModel.position.observe(activity!!, Observer { newPosition ->
                    coroutineGetShopOfSubmenuThucPhamByIndex.onCoroutineGetShopOfSubmenuByIndex(coroutineGetDacSanScope, tabsLayoutBinding, activity!!, newPosition)
                })
            }
            if(submenu == "thucung"){
                thuCungViewModel.position.observe(activity!!, Observer { newPosition ->
                    coroutineGetShopOfSubmenuThuCungByIndex.onCoroutineGetShopOfSubmenuByIndex(coroutineGetThuCungScope, tabsLayoutBinding, activity!!, newPosition)
                })
            }
            if(submenu == "sieuthi"){
                sieuThiViewModel.position.observe(activity!!, Observer { newPosition ->
                    coroutineGetShopOfSubmenuSieuThiByIndex.onCoroutineGetShopOfSubmenuByIndex(coroutineGetSieuThiScope, tabsLayoutBinding, activity!!, newPosition)
                })
            }
    }

    override fun onDestroy() {
        super.onDestroy()
        coroutineGetShopOfSubmenuThucPhamByIndex.onCoroutineDone(getShopThucPhamJob)
        coroutineGetShopOfSubmenuThuCungByIndex.onCoroutineDone(getShopThuCungJob)
        coroutineGetShopOfSubmenuSieuThiByIndex.onCoroutineDone(getShopSieuThiJob)
    }

}
