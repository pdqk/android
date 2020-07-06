package com.example.cloneshopee.home.displayLocation


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import com.example.cloneshopee.R
import com.example.cloneshopee.databinding.FragmentQuanHuyenBinding
import com.example.cloneshopee.home.viewModels.location.MyLocationViewModel

/**
 * A simple [Fragment] subclass.
 */
class FragmentQuanHuyen : Fragment() {
    private lateinit var fragmentQuanHuyenBinding: FragmentQuanHuyenBinding

    private lateinit var myLocationViewModel: MyLocationViewModel


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        fragmentQuanHuyenBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_quan_huyen, container, false)

        myLocationViewModel = ViewModelProviders.of(activity!!).get(MyLocationViewModel::class.java)

        onNavigate()

        return fragmentQuanHuyenBinding.root
    }

    private fun onNavigate(){
        fragmentQuanHuyenBinding.txtvBaDinh.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_fragmentQuanHuyen_to_fragmentPhuongThuocBaDinh)
            myLocationViewModel.setupQuan(activity!!, "Ba Đình")
        }
        fragmentQuanHuyenBinding.txtvHoanKiem.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_fragmentQuanHuyen_to_fragmentPhuongThuocHoanKiem)
            myLocationViewModel.setupQuan(activity!!, "Hoàn Kiếm")
        }
        fragmentQuanHuyenBinding.txtvDongDa.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_fragmentQuanHuyen_to_fragmentPhuongThuocDongDa)
            myLocationViewModel.setupQuan(activity!!, "Đống Đa")
        }
        fragmentQuanHuyenBinding.txtvThanhXuan.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_fragmentQuanHuyen_to_fragmentPhuongThuocThanhXuan)
            myLocationViewModel.setupQuan(activity!!, "Thanh Xuân")
        }
        fragmentQuanHuyenBinding.txtvCauGiay.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_fragmentQuanHuyen_to_fragmentPhuongThuocCauGiay)
            myLocationViewModel.setupQuan(activity!!, "Cầu Giấy")
        }
    }
}
