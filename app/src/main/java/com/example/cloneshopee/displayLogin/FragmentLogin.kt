package com.example.cloneshopee.displayLogin


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.cloneshopee.R
import com.example.cloneshopee.databinding.LoginDisplayBinding

/**
 * A simple [Fragment] subclass.
 */
class FragmentLogin : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val loginFragmentBinding = DataBindingUtil.inflate<LoginDisplayBinding>(inflater, R.layout.login_display, container, false)

        loginFragmentBinding.txtvNavToRegister.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_fragmentLogin_to_fragmentRegister)
        }

        return loginFragmentBinding.root
    }


}
