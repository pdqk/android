package com.example.cloneshopee.main.displayWelcome


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.cloneshopee.R
import com.example.cloneshopee.databinding.WelcomeDisplayBinding

/**
 * A simple [Fragment] subclass.
 */
class FragmentWelcome : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val welcomeFragmentBinding = DataBindingUtil.inflate<WelcomeDisplayBinding>(inflater, R.layout.welcome_display, container, false)

        welcomeFragmentBinding.btnNavToRegister.setOnClickListener {view: View ->
            view.findNavController().navigate(R.id.action_fragmentWelcome_to_fragmentRegister)
        }
        welcomeFragmentBinding.txtvNavToLogin.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_fragmentWelcome_to_fragmentLogin)
        }

        return welcomeFragmentBinding.root
    }


}
