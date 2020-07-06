package com.example.cloneshopee.home.displayLocation


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.example.cloneshopee.R
import com.example.cloneshopee.databinding.FragmentPhuongThuocHoankiemBinding
import com.example.cloneshopee.home.viewModels.location.MyLocationViewModel

/**
 * A simple [Fragment] subclass.
 */
class FragmentPhuongThuocHoanKiem : Fragment() {
    private lateinit var fragmentPhuongThuocHoankiemBinding: FragmentPhuongThuocHoankiemBinding

    private lateinit var myLocationViewModel: MyLocationViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        fragmentPhuongThuocHoankiemBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_phuong_thuoc_hoankiem, container, false)

        myLocationViewModel = ViewModelProviders.of(activity!!).get(MyLocationViewModel::class.java)

        onChosen()

        return fragmentPhuongThuocHoankiemBinding.root
    }

    private fun onChosen(){
        fragmentPhuongThuocHoankiemBinding.txtvChuongDuong.setOnClickListener {
            myLocationViewModel.setupPhuong(activity!!, "Chương Dương")
            myLocationViewModel.onCloseChoose(activity!!)
        }
        fragmentPhuongThuocHoankiemBinding.txtvCuaDong.setOnClickListener {
            myLocationViewModel.setupPhuong(activity!!, "Cửa Đông")
            myLocationViewModel.onCloseChoose(activity!!)
        }
        fragmentPhuongThuocHoankiemBinding.txtvCuaNam.setOnClickListener {
            myLocationViewModel.setupPhuong(activity!!, "Cửa Nam")
            myLocationViewModel.onCloseChoose(activity!!)
        }
        fragmentPhuongThuocHoankiemBinding.txtvDongXuan.setOnClickListener {
            myLocationViewModel.setupPhuong(activity!!, "Đồng Xuân")
            myLocationViewModel.onCloseChoose(activity!!)
        }
        fragmentPhuongThuocHoankiemBinding.txtvHangBac.setOnClickListener {
            myLocationViewModel.setupPhuong(activity!!, "Hàng Bạc")
            myLocationViewModel.onCloseChoose(activity!!)
        }
        fragmentPhuongThuocHoankiemBinding.txtvHangBai.setOnClickListener {
            myLocationViewModel.setupPhuong(activity!!, "Hàng Bài")
            myLocationViewModel.onCloseChoose(activity!!)
        }
        fragmentPhuongThuocHoankiemBinding.txtvHangBo.setOnClickListener {
            myLocationViewModel.setupPhuong(activity!!, "Hàng Bồ")
            myLocationViewModel.onCloseChoose(activity!!)
        }
        fragmentPhuongThuocHoankiemBinding.txtvHangBuom.setOnClickListener {
            myLocationViewModel.setupPhuong(activity!!, "Hàng Buồm")
            myLocationViewModel.onCloseChoose(activity!!)
        }
        fragmentPhuongThuocHoankiemBinding.txtvHangDao.setOnClickListener {
            myLocationViewModel.setupPhuong(activity!!, "Hàng Đào")
            myLocationViewModel.onCloseChoose(activity!!)
        }
        fragmentPhuongThuocHoankiemBinding.txtvHangGai.setOnClickListener {
            myLocationViewModel.setupPhuong(activity!!, "Hàng Gai")
            myLocationViewModel.onCloseChoose(activity!!)
        }
        fragmentPhuongThuocHoankiemBinding.txtvHangMa.setOnClickListener {
            myLocationViewModel.setupPhuong(activity!!, "Hàng Mã")
            myLocationViewModel.onCloseChoose(activity!!)
        }
        fragmentPhuongThuocHoankiemBinding.txtvHangTrong.setOnClickListener {
            myLocationViewModel.setupPhuong(activity!!, "Hàng Trống")
            myLocationViewModel.onCloseChoose(activity!!)
        }
        fragmentPhuongThuocHoankiemBinding.txtvLyThaiTo.setOnClickListener {
            myLocationViewModel.setupPhuong(activity!!, "Lý Thái Tổ")
            myLocationViewModel.onCloseChoose(activity!!)
        }
        fragmentPhuongThuocHoankiemBinding.txtvTrangTien.setOnClickListener {
            myLocationViewModel.setupPhuong(activity!!, "Tràng Tiền")
            myLocationViewModel.onCloseChoose(activity!!)
        }
    }

}
