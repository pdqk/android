package com.example.cloneshopee.home.coroutines.homepage

import android.app.Activity
import android.content.Intent
import android.view.View
import com.example.cloneshopee.databinding.HomePageDisplayBinding
import com.example.cloneshopee.home.displayMenuSelected.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class CoroutineSetupMenuNavigation {
    fun onSettingUpMenuNavigation(coroutineScope: CoroutineScope, activity: Activity, homePageDisplayBinding: HomePageDisplayBinding){
        coroutineScope.launch {
            val sharedPreferences = activity!!.getSharedPreferences("CurrentSubmenu", 0)
            val editor = sharedPreferences.edit()

            homePageDisplayBinding.imgvThucPham.setOnClickListener { view: View ->
                editor.putString("submenu","thucpham")
                editor.apply()
                editor.commit()
                val intent = Intent(activity, ThucPhamActivity::class.java)
                activity.startActivity(intent)
            }
            homePageDisplayBinding.imgvThuCung.setOnClickListener { view: View ->
                editor.putString("submenu","thucung")
                editor.apply()
                editor.commit()
                val intent = Intent(activity, ThuCungActivity::class.java)
                activity.startActivity(intent)
            }
            homePageDisplayBinding.imgvSieuThi.setOnClickListener { view: View ->
                editor.putString("submenu","sieuthi")
                editor.apply()
                editor.commit()
                val intent = Intent(activity, SieuThiActivity::class.java)
                activity.startActivity(intent)
            }
            homePageDisplayBinding.imgvHoa.setOnClickListener { view: View ->
                editor.putString("submenu","hoa")
                editor.apply()
                editor.commit()
                val intent = Intent(activity, HoaActivity::class.java)
                activity.startActivity(intent)
            }
            homePageDisplayBinding.imgvRuouBia.setOnClickListener { view: View ->
                editor.putString("submenu","ruoubia")
                editor.apply()
                editor.commit()
                val intent = Intent(activity, RuouBiaActivity::class.java)
                activity.startActivity(intent)
            }
            homePageDisplayBinding.imgvThuoc.setOnClickListener { view: View ->
                editor.putString("submenu","thuoc")
                editor.apply()
                editor.commit()
                val intent = Intent(activity, ThuocActivity::class.java)
                activity.startActivity(intent)
            }
            homePageDisplayBinding.imgvLamDep.setOnClickListener { view: View ->
                editor.putString("submenu","lamdep")
                editor.apply()
                editor.commit()
                val intent = Intent(activity, LamDepActivity::class.java)
                activity.startActivity(intent)
            }
            homePageDisplayBinding.imgvGiatUi.setOnClickListener { view: View ->
                editor.putString("submenu","giatui")
                editor.apply()
                editor.commit()
                val intent = Intent(activity, GiatUiActivity::class.java)
                activity.startActivity(intent)
            }
            homePageDisplayBinding.imgvAnVat.setOnClickListener { view: View ->
                editor.putString("submenu","anvat")
                editor.apply()
                editor.commit()
                val intent = Intent(activity, AnVatActivity::class.java)
                activity.startActivity(intent)
            }
            homePageDisplayBinding.imgvTraSua.setOnClickListener { view: View ->
                editor.putString("submenu","trasua")
                editor.apply()
                editor.commit()
                val intent = Intent(activity, TraSuaActivity::class.java)
                activity.startActivity(intent)
            }
            homePageDisplayBinding.imgvCom.setOnClickListener { view: View ->
                editor.putString("submenu","com")
                editor.apply()
                editor.commit()
                val intent = Intent(activity, ComActivity::class.java)
                activity.startActivity(intent)
            }
        }
    }

    fun onDone(job: Job){
        job.cancel()
    }
}