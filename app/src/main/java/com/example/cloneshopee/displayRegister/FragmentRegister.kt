package com.example.cloneshopee.displayRegister


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.cloneshopee.R
import com.example.cloneshopee.databinding.RegisterDisplayBinding

/**
 * A simple [Fragment] subclass.
 */
class FragmentRegister : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val registerFragmentBinding = DataBindingUtil.inflate<RegisterDisplayBinding>(inflater, R.layout.register_display, container, false)

        registerFragmentBinding.btnBackToWelcome.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_fragmentRegister_to_fragmentWelcome)
        }
        registerFragmentBinding.btnNavToLogin.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_fragmentRegister_to_fragmentLogin)
        }

        return registerFragmentBinding.root
    }


}
