package com.example.cloneshopee.home.displayHomePage


import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.cloneshopee.R
import com.example.cloneshopee.databinding.HomePageDisplayBinding
import com.example.cloneshopee.home.coroutines.homepage.CoroutineSliderImageHomepage
import com.example.cloneshopee.home.coroutines.homepage.CoroutineVoucherHomepage
import com.example.cloneshopee.home.displayLocation.DisplayChooseMyLocation
import com.example.cloneshopee.home.displayMenuSelected.*
import com.example.cloneshopee.home.recyclerViewAdapter.homepage.ViewPagerAdapter
import com.example.cloneshopee.home.viewModels.location.MyLocationViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job

/**
 * A simple [Fragment] subclass.
 */
class FragmentHomePage : Fragment() {
    private lateinit var homePageDisplayBinding: HomePageDisplayBinding

    private lateinit var myLocationViewModel: MyLocationViewModel

    private var slideImageJob = Job()
    private var voucherJob = Job()
    private var coroutineSlideImageScope = CoroutineScope(slideImageJob + Dispatchers.Main)
    private var coroutineVoucherScope = CoroutineScope(voucherJob + Dispatchers.Main)

    var coroutineSliderImageHomepage = CoroutineSliderImageHomepage()
    var coroutineVoucherHomepage = CoroutineVoucherHomepage()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        homePageDisplayBinding = DataBindingUtil.inflate(inflater, R.layout.home_page_display, container, false)

        myLocationViewModel = ViewModelProviders.of(activity!!).get(MyLocationViewModel::class.java)
        myLocationViewModel.setupAddress(activity!!)

        setupSliderImage()
        setupVoucher()
        setupMenuNavigation()
        setupTabLayouts()
        setupMyLocation()
        displayMyLocation()

        return homePageDisplayBinding.root
    }

    private fun setupSliderImage(){
        coroutineSliderImageHomepage.onCoroutineGetSlideImage(coroutineSlideImageScope, activity!!, homePageDisplayBinding)
    }

    private fun setupVoucher(){
        coroutineVoucherHomepage.onCoroutineGetVoucher(coroutineVoucherScope, homePageDisplayBinding, activity!!)
    }

    private fun setupTabLayouts(){
        val viewpagerAdapter = ViewPagerAdapter(activity!!.supportFragmentManager)
        homePageDisplayBinding.dontHaveSubmenuInHomepage.viewpagerShared.adapter = viewpagerAdapter
        homePageDisplayBinding.dontHaveSubmenuInHomepage.tabsShared.setupWithViewPager(homePageDisplayBinding.dontHaveSubmenuInHomepage.viewpagerShared)
        homePageDisplayBinding.dontHaveSubmenuInHomepage.tabsShared.setSelectedTabIndicatorColor(
            Color.parseColor("#FF0000")
        )
        homePageDisplayBinding.dontHaveSubmenuInHomepage.tabsShared.setTabTextColors(Color.parseColor("#1d1d1f"), Color.parseColor("#FF0000"))
    }

    private fun setupMyLocation(){
        homePageDisplayBinding.txtvNavToAddressReceiveOrder.setOnClickListener {
            val fm = activity!!.supportFragmentManager
            val displayChooseMyLocation = DisplayChooseMyLocation()
            displayChooseMyLocation.show(fm, "TAG")
        }
    }

    private fun displayMyLocation(){
        myLocationViewModel.myLocation.observe(activity!!, Observer { newLocation ->
            homePageDisplayBinding.txtvNavToAddressReceiveOrder.text = newLocation
        })
    }

    private fun setupMenuNavigation(){
        val sharedPreferences = activity!!.getSharedPreferences("CurrentSubmenu", 0)
        val editor = sharedPreferences.edit()

        homePageDisplayBinding.imgvThucPham.setOnClickListener { view: View ->
            editor.putString("submenu","thucpham")
            editor.apply()
            editor.commit()
            val intent = Intent(activity, ThucPhamActivity::class.java)
            startActivity(intent)
        }
        homePageDisplayBinding.imgvThuCung.setOnClickListener { view: View ->
            editor.putString("submenu","thucung")
            editor.apply()
            editor.commit()
            val intent = Intent(activity, ThuCungActivity::class.java)
            startActivity(intent)
        }
        homePageDisplayBinding.imgvSieuThi.setOnClickListener { view: View ->
            editor.putString("submenu","sieuthi")
            editor.apply()
            editor.commit()
            val intent = Intent(activity, SieuThiActivity::class.java)
            startActivity(intent)
        }
        homePageDisplayBinding.imgvHoa.setOnClickListener { view: View ->
            editor.putString("submenu","hoa")
            editor.apply()
            editor.commit()
            val intent = Intent(activity, HoaActivity::class.java)
            startActivity(intent)
        }
        homePageDisplayBinding.imgvRuouBia.setOnClickListener { view: View ->
            editor.putString("submenu","ruoubia")
            editor.apply()
            editor.commit()
            val intent = Intent(activity, RuouBiaActivity::class.java)
            startActivity(intent)
        }
        homePageDisplayBinding.imgvThuoc.setOnClickListener { view: View ->
            editor.putString("submenu","thuoc")
            editor.apply()
            editor.commit()
            val intent = Intent(activity, ThuocActivity::class.java)
            startActivity(intent)
        }
        homePageDisplayBinding.imgvLamDep.setOnClickListener { view: View ->
            editor.putString("submenu","lamdep")
            editor.apply()
            editor.commit()
            val intent = Intent(activity, LamDepActivity::class.java)
            startActivity(intent)
        }
        homePageDisplayBinding.imgvGiatUi.setOnClickListener { view: View ->
            editor.putString("submenu","giatui")
            editor.apply()
            editor.commit()
            val intent = Intent(activity, GiatUiActivity::class.java)
            startActivity(intent)
        }
        homePageDisplayBinding.imgvAnVat.setOnClickListener { view: View ->
            editor.putString("submenu","anvat")
            editor.apply()
            editor.commit()
            val intent = Intent(activity, AnVatActivity::class.java)
            startActivity(intent)
        }
        homePageDisplayBinding.imgvTraSua.setOnClickListener { view: View ->
            editor.putString("submenu","trasua")
            editor.apply()
            editor.commit()
            val intent = Intent(activity, TraSuaActivity::class.java)
            startActivity(intent)
        }
        homePageDisplayBinding.imgvCom.setOnClickListener { view: View ->
            editor.putString("submenu","com")
            editor.apply()
            editor.commit()
            val intent = Intent(activity, ComActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onStop() {
        super.onStop()
        coroutineSliderImageHomepage.onCoroutineDone(slideImageJob)
        coroutineVoucherHomepage.onCoroutineDone(voucherJob)
    }

    override fun onDestroy() {
        super.onDestroy()
        coroutineSliderImageHomepage.onCoroutineDone(slideImageJob)
        coroutineVoucherHomepage.onCoroutineDone(voucherJob)
    }
}
