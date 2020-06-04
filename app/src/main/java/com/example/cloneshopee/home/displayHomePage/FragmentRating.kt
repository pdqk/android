package com.example.cloneshopee.home.displayHomePage


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.cloneshopee.R
import com.example.cloneshopee.databinding.TabsLayoutBinding
import com.example.cloneshopee.home.coroutines.menu.anvat.CoroutineAllMenuAnVat
import com.example.cloneshopee.home.coroutines.menu.com.CoroutineAllMenuCom
import com.example.cloneshopee.home.coroutines.menu.giatui.CoroutineSubmenuGiatUiByIndex
import com.example.cloneshopee.home.coroutines.menu.hoa.CoroutineSubmenuHoaByIndex
import com.example.cloneshopee.home.coroutines.menu.lamdep.CoroutineSubmenuLamDepByIndex
import com.example.cloneshopee.home.coroutines.menu.ruoubia.CoroutineSubmenuRuouBiaByIndex
import com.example.cloneshopee.home.coroutines.menu.sieuthi.CoroutineSubmenuSieuThiByIndex
import com.example.cloneshopee.home.coroutines.menu.thucpham.CoroutineSubmenuByIndex
import com.example.cloneshopee.home.coroutines.menu.thucung.CoroutineSubmenuThuCungByIndex
import com.example.cloneshopee.home.coroutines.menu.thuoc.CoroutineSubmenuThuocByIndex
import com.example.cloneshopee.home.coroutines.menu.trasua.CoroutineAllMenuTraSua
import com.example.cloneshopee.home.viewModels.menu.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job

/**
 * A simple [Fragment] subclass.
 */
class FragmentRating : Fragment() {
    private  lateinit var tabsLayoutBinding: TabsLayoutBinding

    private lateinit var thucPhamViewModel: ThucPhamViewModel
    private lateinit var thuCungViewModel: ThuCungViewModel
    private lateinit var sieuThiViewModel: SieuThiViewModel
    private lateinit var hoaViewModel: HoaViewModel
    private lateinit var ruouBiaViewModel: RuouBiaViewModel
    private lateinit var thuocViewModel: ThuocViewModel
    private lateinit var lamDepViewModel: LamDepViewModel
    private lateinit var giatUiViewModel: GiatUiViewModel

    private var getShopDacSanJob = Job()
    private var coroutineGetDacSanScope = CoroutineScope(getShopDacSanJob + Dispatchers.Main)
    var coroutineGetShopOfSubmenuThucPhamByIndex = CoroutineSubmenuByIndex()

    private var getShopThuCungJob = Job()
    private var coroutineGetThuCungScope = CoroutineScope(getShopThuCungJob + Dispatchers.Main)
    var coroutineGetShopOfSubmenuThuCungByIndex = CoroutineSubmenuThuCungByIndex()

    private var getShopSieuThiJob = Job()
    private var coroutineGetSieuThiScope = CoroutineScope(getShopSieuThiJob + Dispatchers.Main)
    var coroutineGetShopOfSubmenuSieuThiByIndex = CoroutineSubmenuSieuThiByIndex()

    private var getShopHoaJob = Job()
    private var coroutineGetHoaScope = CoroutineScope(getShopHoaJob + Dispatchers.Main)
    var coroutineGetShopOfSubmenuHoaByIndex = CoroutineSubmenuHoaByIndex()

    private var getShopRuouBiaJob = Job()
    private var coroutineGetRuouBiaScope = CoroutineScope(getShopRuouBiaJob + Dispatchers.Main)
    var coroutineGetShopOfSubmenuRuouBiaByIndex = CoroutineSubmenuRuouBiaByIndex()

    private var getShopThuocJob = Job()
    private var coroutineGetThuocScope = CoroutineScope(getShopThuocJob + Dispatchers.Main)
    var coroutineGetShopOfSubmenuThuocByIndex = CoroutineSubmenuThuocByIndex()

    private var getShopLamDepJob = Job()
    private var coroutineGetLamDepScope = CoroutineScope(getShopLamDepJob + Dispatchers.Main)
    var coroutineGetShopOfSubmenuLamDepByIndex = CoroutineSubmenuLamDepByIndex()

    private var getShopGiatUiJob = Job()
    private var coroutineGetGiatUiScope = CoroutineScope(getShopGiatUiJob + Dispatchers.Main)
    var coroutineGetShopOfSubmenuGiatUiByIndex = CoroutineSubmenuGiatUiByIndex()

    private var getShopAnVatJob = Job()
    private var coroutineGetAnVatScope = CoroutineScope(getShopAnVatJob + Dispatchers.Main)
    var coroutineGetAllMenuAnVat = CoroutineAllMenuAnVat()

    private var getShopTraSuaJob = Job()
    private var coroutineGetTraSuaScope = CoroutineScope(getShopTraSuaJob + Dispatchers.Main)
    var coroutineGetAllMenuTraSua = CoroutineAllMenuTraSua()

    private var getShopComJob = Job()
    private var coroutineGetComScope = CoroutineScope(getShopComJob + Dispatchers.Main)
    var coroutineGetAllMenuCom = CoroutineAllMenuCom()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        tabsLayoutBinding = DataBindingUtil.inflate(inflater, R.layout.tabs_layout, container, false)

        thucPhamViewModel = ViewModelProviders.of(activity!!).get(ThucPhamViewModel::class.java)
        thuCungViewModel = ViewModelProviders.of(activity!!).get(ThuCungViewModel::class.java)
        sieuThiViewModel = ViewModelProviders.of(activity!!).get(SieuThiViewModel::class.java)
        hoaViewModel = ViewModelProviders.of(activity!!).get(HoaViewModel::class.java)
        ruouBiaViewModel = ViewModelProviders.of(activity!!).get(RuouBiaViewModel::class.java)
        thuocViewModel = ViewModelProviders.of(activity!!).get(ThuocViewModel::class.java)
        lamDepViewModel = ViewModelProviders.of(activity!!).get(LamDepViewModel::class.java)
        giatUiViewModel = ViewModelProviders.of(activity!!).get(GiatUiViewModel::class.java)

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
        if(submenu == "hoa"){
            hoaViewModel.position.observe(activity!!, Observer { newPosition ->
                coroutineGetShopOfSubmenuHoaByIndex.onCoroutineGetShopOfSubmenuByIndex(coroutineGetHoaScope, tabsLayoutBinding, activity!!, newPosition)
            })
        }
        if(submenu == "ruoubia"){
            ruouBiaViewModel.position.observe(activity!!, Observer { newPosition ->
                coroutineGetShopOfSubmenuRuouBiaByIndex.onCoroutineGetShopOfSubmenuByIndex(coroutineGetRuouBiaScope, tabsLayoutBinding, activity!!, newPosition)
            })
        }
        if(submenu == "thuoc"){
            thuocViewModel.position.observe(activity!!, Observer { newPosition ->
                coroutineGetShopOfSubmenuThuocByIndex.onCoroutineGetShopOfSubmenuByIndex(coroutineGetThuocScope, tabsLayoutBinding, activity!!, newPosition)
            })
        }
        if(submenu == "lamdep"){
            lamDepViewModel.position.observe(activity!!, Observer { newPosition ->
                coroutineGetShopOfSubmenuLamDepByIndex.onCoroutineGetShopOfSubmenuByIndex(coroutineGetLamDepScope, tabsLayoutBinding, activity!!, newPosition)
            })
        }
        if(submenu == "giatui"){
            giatUiViewModel.position.observe(activity!!, Observer { newPosition ->
                coroutineGetShopOfSubmenuGiatUiByIndex.onCoroutineGetShopOfSubmenuByIndex(coroutineGetGiatUiScope, tabsLayoutBinding, activity!!, newPosition)
            })
        }
        if(submenu == "anvat"){
            coroutineGetAllMenuAnVat.onCoroutineGetAllMenuAnVat(coroutineGetAnVatScope, tabsLayoutBinding, activity!!)
        }
        if(submenu == "trasua"){
            coroutineGetAllMenuTraSua.onCoroutineGetAllMenuTraSua(coroutineGetTraSuaScope, tabsLayoutBinding, activity!!)
        }
        if(submenu == "com"){
            coroutineGetAllMenuCom.onCoroutineGetAllMenuCom(coroutineGetComScope, tabsLayoutBinding, activity!!)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        coroutineGetShopOfSubmenuThucPhamByIndex.onCoroutineDone(getShopDacSanJob)
        coroutineGetShopOfSubmenuThuCungByIndex.onCoroutineDone(getShopThuCungJob)
        coroutineGetShopOfSubmenuSieuThiByIndex.onCoroutineDone(getShopSieuThiJob)
        coroutineGetShopOfSubmenuHoaByIndex.onCoroutineDone(getShopHoaJob)
        coroutineGetShopOfSubmenuRuouBiaByIndex.onCoroutineDone(getShopRuouBiaJob)
        coroutineGetShopOfSubmenuThuocByIndex.onCoroutineDone(getShopThuocJob)
        coroutineGetShopOfSubmenuLamDepByIndex.onCoroutineDone(getShopLamDepJob)
        coroutineGetShopOfSubmenuGiatUiByIndex.onCoroutineDone(getShopGiatUiJob)
        coroutineGetAllMenuAnVat.onCoroutineDone(getShopAnVatJob)
        coroutineGetAllMenuTraSua.onCoroutineDone(getShopTraSuaJob)
        coroutineGetAllMenuCom.onCoroutineDone(getShopComJob)
    }

}
