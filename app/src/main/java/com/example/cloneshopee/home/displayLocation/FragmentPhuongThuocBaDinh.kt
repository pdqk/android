package com.example.cloneshopee.home.displayLocation


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.example.cloneshopee.R
import com.example.cloneshopee.databinding.FragmentPhuongThuocBadinhBinding
import com.example.cloneshopee.home.viewModels.location.MyLocationViewModel

/**
 * A simple [Fragment] subclass.
 */
class FragmentPhuongThuocBaDinh : Fragment() {
    private lateinit var fragmentPhuongThuocBadinhBinding: FragmentPhuongThuocBadinhBinding

    private lateinit var myLocationViewModel: MyLocationViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        fragmentPhuongThuocBadinhBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_phuong_thuoc_badinh, container, false)

        myLocationViewModel = ViewModelProviders.of(activity!!).get(MyLocationViewModel::class.java)

        onChosen()

        return fragmentPhuongThuocBadinhBinding.root
    }

    private fun onChosen(){
        fragmentPhuongThuocBadinhBinding.txtvCongVi.setOnClickListener {
            myLocationViewModel.setupPhuong(activity!!, "Cống Vị")
            myLocationViewModel.onCloseChoose(activity!!)
        }
        fragmentPhuongThuocBadinhBinding.txtvDienBien.setOnClickListener {
            myLocationViewModel.setupPhuong(activity!!, "Điện Biên")
            myLocationViewModel.onCloseChoose(activity!!)
        }
        fragmentPhuongThuocBadinhBinding.txtvDoiCan.setOnClickListener {
            myLocationViewModel.setupPhuong(activity!!, "Đội Cấn")
            myLocationViewModel.onCloseChoose(activity!!)
        }
        fragmentPhuongThuocBadinhBinding.txtvGiangVo.setOnClickListener {
            myLocationViewModel.setupPhuong(activity!!, "Giảng Võ")
            myLocationViewModel.onCloseChoose(activity!!)
        }
        fragmentPhuongThuocBadinhBinding.txtvKimMa.setOnClickListener {
            myLocationViewModel.setupPhuong(activity!!, "Kim Mã")
            myLocationViewModel.onCloseChoose(activity!!)
        }
        fragmentPhuongThuocBadinhBinding.txtvLieuGiai.setOnClickListener {
            myLocationViewModel.setupPhuong(activity!!, "Liễu Giai")
            myLocationViewModel.onCloseChoose(activity!!)
        }
        fragmentPhuongThuocBadinhBinding.txtvNgocHa.setOnClickListener {
            myLocationViewModel.setupPhuong(activity!!, "Ngọc Hà")
            myLocationViewModel.onCloseChoose(activity!!)
        }
        fragmentPhuongThuocBadinhBinding.txtvNgocKhanh.setOnClickListener {
            myLocationViewModel.setupPhuong(activity!!, "Ngọc Khánh")
            myLocationViewModel.onCloseChoose(activity!!)
        }
        fragmentPhuongThuocBadinhBinding.txtvNguyenTrungTruc.setOnClickListener {
            myLocationViewModel.setupPhuong(activity!!, "Nguyễn Trung Trực")
            myLocationViewModel.onCloseChoose(activity!!)
        }
        fragmentPhuongThuocBadinhBinding.txtvPhucXa.setOnClickListener {
            myLocationViewModel.setupPhuong(activity!!, "Phúc Xá")
            myLocationViewModel.onCloseChoose(activity!!)
        }
        fragmentPhuongThuocBadinhBinding.txtvQuanThanh.setOnClickListener {
            myLocationViewModel.setupPhuong(activity!!, "Quán Thánh")
            myLocationViewModel.onCloseChoose(activity!!)
        }
        fragmentPhuongThuocBadinhBinding.txtvThanhCong.setOnClickListener {
            myLocationViewModel.setupPhuong(activity!!, "Thành Công")
            myLocationViewModel.onCloseChoose(activity!!)
        }
        fragmentPhuongThuocBadinhBinding.txtvTrucBach.setOnClickListener {
            myLocationViewModel.setupPhuong(activity!!, "Trúc Bạch")
            myLocationViewModel.onCloseChoose(activity!!)
        }
        fragmentPhuongThuocBadinhBinding.txtvVinhPhuc.setOnClickListener {
            myLocationViewModel.setupPhuong(activity!!, "Vĩnh Phúc")
            myLocationViewModel.onCloseChoose(activity!!)
        }
    }
}
