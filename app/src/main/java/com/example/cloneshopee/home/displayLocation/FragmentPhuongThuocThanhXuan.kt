package com.example.cloneshopee.home.displayLocation


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.example.cloneshopee.R
import com.example.cloneshopee.databinding.FragmentPhuongThuocThanhxuanBinding
import com.example.cloneshopee.home.viewModels.location.MyLocationViewModel

/**
 * A simple [Fragment] subclass.
 */
class FragmentPhuongThuocThanhXuan : Fragment() {
    private lateinit var fragmentPhuongThuocThanhxuanBinding: FragmentPhuongThuocThanhxuanBinding

    private lateinit var myLocationViewModel: MyLocationViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        fragmentPhuongThuocThanhxuanBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_phuong_thuoc_thanhxuan, container, false)

        myLocationViewModel = ViewModelProviders.of(activity!!).get(MyLocationViewModel::class.java)

        onChosen()

        return fragmentPhuongThuocThanhxuanBinding.root
    }

    private fun onChosen(){
        fragmentPhuongThuocThanhxuanBinding.txtvDaiKim.setOnClickListener {
            myLocationViewModel.setupPhuong(activity!!, "Đại Kim")
            myLocationViewModel.onCloseChoose(activity!!)
        }
        fragmentPhuongThuocThanhxuanBinding.txtvDinhCong.setOnClickListener {
            myLocationViewModel.setupPhuong(activity!!, "Định Công")
            myLocationViewModel.onCloseChoose(activity!!)
        }
        fragmentPhuongThuocThanhxuanBinding.txtvGiapBat.setOnClickListener {
            myLocationViewModel.setupPhuong(activity!!, "Giáp Bát")
            myLocationViewModel.onCloseChoose(activity!!)
        }
        fragmentPhuongThuocThanhxuanBinding.txtvHoangLiet.setOnClickListener {
            myLocationViewModel.setupPhuong(activity!!, "Hoàng Liệt")
            myLocationViewModel.onCloseChoose(activity!!)
        }
        fragmentPhuongThuocThanhxuanBinding.txtvHoangVanThu.setOnClickListener {
            myLocationViewModel.setupPhuong(activity!!, "Hoàng Văn Thụ")
            myLocationViewModel.onCloseChoose(activity!!)
        }
        fragmentPhuongThuocThanhxuanBinding.txtvLinhNam.setOnClickListener {
            myLocationViewModel.setupPhuong(activity!!, "Lĩnh Nam")
            myLocationViewModel.onCloseChoose(activity!!)
        }
        fragmentPhuongThuocThanhxuanBinding.txtvMaiDong.setOnClickListener {
            myLocationViewModel.setupPhuong(activity!!, "Mai Động")
            myLocationViewModel.onCloseChoose(activity!!)
        }
        fragmentPhuongThuocThanhxuanBinding.txtvTanMai.setOnClickListener {
            myLocationViewModel.setupPhuong(activity!!, "Tân Mai")
            myLocationViewModel.onCloseChoose(activity!!)
        }
        fragmentPhuongThuocThanhxuanBinding.txtvThanhTri.setOnClickListener {
            myLocationViewModel.setupPhuong(activity!!, "Thanh Trì")
            myLocationViewModel.onCloseChoose(activity!!)
        }
        fragmentPhuongThuocThanhxuanBinding.txtvThinhLiet.setOnClickListener {
            myLocationViewModel.setupPhuong(activity!!, "Thịnh Liệt")
            myLocationViewModel.onCloseChoose(activity!!)
        }
        fragmentPhuongThuocThanhxuanBinding.txtvTranPhu.setOnClickListener {
            myLocationViewModel.setupPhuong(activity!!, "Trần Phú")
            myLocationViewModel.onCloseChoose(activity!!)
        }
        fragmentPhuongThuocThanhxuanBinding.txtvYenSo.setOnClickListener {
            myLocationViewModel.setupPhuong(activity!!, "Yên Sở")
            myLocationViewModel.onCloseChoose(activity!!)
        }
    }

}
