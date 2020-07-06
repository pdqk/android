package com.example.cloneshopee.home.displayLocation


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.example.cloneshopee.R
import com.example.cloneshopee.databinding.FragmentPhuongThuocDongdaBinding
import com.example.cloneshopee.home.viewModels.location.MyLocationViewModel

/**
 * A simple [Fragment] subclass.
 */
class FragmentPhuongThuocDongDa : Fragment() {
    private lateinit var fragmentPhuongThuocDongdaBinding: FragmentPhuongThuocDongdaBinding

    private lateinit var myLocationViewModel: MyLocationViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        fragmentPhuongThuocDongdaBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_phuong_thuoc_dongda, container, false)

        myLocationViewModel = ViewModelProviders.of(activity!!).get(MyLocationViewModel::class.java)

        onChosen()

        return fragmentPhuongThuocDongdaBinding.root
    }

    private fun onChosen(){
        fragmentPhuongThuocDongdaBinding.txtvCatLinh.setOnClickListener {
            myLocationViewModel.setupPhuong(activity!!, "Cát Linh")
            myLocationViewModel.onCloseChoose(activity!!)
        }
        fragmentPhuongThuocDongdaBinding.txtvHangBot.setOnClickListener {
            myLocationViewModel.setupPhuong(activity!!, "Hàng Bột")
            myLocationViewModel.onCloseChoose(activity!!)
        }
        fragmentPhuongThuocDongdaBinding.txtvKhamThien.setOnClickListener {
            myLocationViewModel.setupPhuong(activity!!, "Khâm Thiên")
            myLocationViewModel.onCloseChoose(activity!!)
        }
        fragmentPhuongThuocDongdaBinding.txtvKhuongThuong.setOnClickListener {
            myLocationViewModel.setupPhuong(activity!!, "Khương Thượng")
            myLocationViewModel.onCloseChoose(activity!!)
        }
        fragmentPhuongThuocDongdaBinding.txtvKimLien.setOnClickListener {
            myLocationViewModel.setupPhuong(activity!!, "Kim Liên")
            myLocationViewModel.onCloseChoose(activity!!)
        }
        fragmentPhuongThuocDongdaBinding.txtvLangHa.setOnClickListener {
            myLocationViewModel.setupPhuong(activity!!, "Láng Hạ")
            myLocationViewModel.onCloseChoose(activity!!)
        }
        fragmentPhuongThuocDongdaBinding.txtvLangThien.setOnClickListener {
            myLocationViewModel.setupPhuong(activity!!, "Láng Thiện")
            myLocationViewModel.onCloseChoose(activity!!)
        }
        fragmentPhuongThuocDongdaBinding.txtvNamDong.setOnClickListener {
            myLocationViewModel.setupPhuong(activity!!, "Nam Đồng")
            myLocationViewModel.onCloseChoose(activity!!)
        }
        fragmentPhuongThuocDongdaBinding.txtvNgaTuSo.setOnClickListener {
            myLocationViewModel.setupPhuong(activity!!, "Ngã Tư Sở")
            myLocationViewModel.onCloseChoose(activity!!)
        }
        fragmentPhuongThuocDongdaBinding.txtvOCuaDua.setOnClickListener {
            myLocationViewModel.setupPhuong(activity!!, "Ô Cửa Dừa")
            myLocationViewModel.onCloseChoose(activity!!)
        }
        fragmentPhuongThuocDongdaBinding.txtvPhuongLien.setOnClickListener {
            myLocationViewModel.setupPhuong(activity!!, "Phương Liên")
            myLocationViewModel.onCloseChoose(activity!!)
        }
        fragmentPhuongThuocDongdaBinding.txtvPhuongMai.setOnClickListener {
            myLocationViewModel.setupPhuong(activity!!, "Phương Mai")
            myLocationViewModel.onCloseChoose(activity!!)
        }
        fragmentPhuongThuocDongdaBinding.txtvQuangTrung.setOnClickListener {
            myLocationViewModel.setupPhuong(activity!!, "Quang Trung")
            myLocationViewModel.onCloseChoose(activity!!)
        }
        fragmentPhuongThuocDongdaBinding.txtvQuocTuGiam.setOnClickListener {
            myLocationViewModel.setupPhuong(activity!!, "Quốc Từ Giám")
            myLocationViewModel.onCloseChoose(activity!!)
        }
    }
}
