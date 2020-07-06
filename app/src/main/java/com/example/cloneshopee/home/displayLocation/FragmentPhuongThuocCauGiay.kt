package com.example.cloneshopee.home.displayLocation


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.example.cloneshopee.R
import com.example.cloneshopee.databinding.FragmentPhuongThuocCaugiayBinding
import com.example.cloneshopee.home.viewModels.location.MyLocationViewModel

/**
 * A simple [Fragment] subclass.
 */
class FragmentPhuongThuocCauGiay : Fragment() {
    private lateinit var fragmentPhuongThuocCaugiayBinding: FragmentPhuongThuocCaugiayBinding

    private lateinit var myLocationViewModel: MyLocationViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        fragmentPhuongThuocCaugiayBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_phuong_thuoc_caugiay, container, false)

        myLocationViewModel = ViewModelProviders.of(activity!!).get(MyLocationViewModel::class.java)

        onChosen()

        return fragmentPhuongThuocCaugiayBinding.root
    }

    private fun onChosen(){
        fragmentPhuongThuocCaugiayBinding.txtvDichVong.setOnClickListener {
            myLocationViewModel.setupPhuong(activity!!, "Dịch Vọng")
            myLocationViewModel.onCloseChoose(activity!!)
        }
        fragmentPhuongThuocCaugiayBinding.txtvDichVongHau.setOnClickListener {
            myLocationViewModel.setupPhuong(activity!!, "Dịch Vọng Hậu")
            myLocationViewModel.onCloseChoose(activity!!)
        }
        fragmentPhuongThuocCaugiayBinding.txtvMaiDich.setOnClickListener {
            myLocationViewModel.setupPhuong(activity!!, "Mai Dịch")
            myLocationViewModel.onCloseChoose(activity!!)
        }
        fragmentPhuongThuocCaugiayBinding.txtvNghiaDo.setOnClickListener {
            myLocationViewModel.setupPhuong(activity!!, "Nghĩa Đô")
            myLocationViewModel.onCloseChoose(activity!!)
        }
        fragmentPhuongThuocCaugiayBinding.txtvNghiaTan.setOnClickListener {
            myLocationViewModel.setupPhuong(activity!!, "Nghĩa Tân")
            myLocationViewModel.onCloseChoose(activity!!)
        }
        fragmentPhuongThuocCaugiayBinding.txtvQuanHoa.setOnClickListener {
            myLocationViewModel.setupPhuong(activity!!, "Quan Hoa")
            myLocationViewModel.onCloseChoose(activity!!)
        }
        fragmentPhuongThuocCaugiayBinding.txtvTrungHoa.setOnClickListener {
            myLocationViewModel.setupPhuong(activity!!, "Trung Hòa")
            myLocationViewModel.onCloseChoose(activity!!)
        }
        fragmentPhuongThuocCaugiayBinding.txtvYenHoa.setOnClickListener {
            myLocationViewModel.setupPhuong(activity!!, "Yên Hòa")
            myLocationViewModel.onCloseChoose(activity!!)
        }
    }
}
