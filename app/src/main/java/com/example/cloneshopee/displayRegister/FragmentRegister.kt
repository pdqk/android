package com.example.cloneshopee.displayRegister

import android.os.Bundle
import android.util.Patterns
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.cloneshopee.R
import com.example.cloneshopee.databinding.RegisterDisplayBinding
import com.example.cloneshopee.fireBase.FirebaseUsersStore

/**
 * A simple [Fragment] subclass.
 */
class FragmentRegister : Fragment(){
    private lateinit var registerFragmentBinding: RegisterDisplayBinding
    private lateinit var firebaseUsersStore: FirebaseUsersStore

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        registerFragmentBinding = DataBindingUtil.inflate(inflater, R.layout.register_display, container, false)

        buttonControl()

        return registerFragmentBinding.root
    }

    private fun buttonControl(){
        registerFragmentBinding.btnBackToWelcome.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_fragmentRegister_to_fragmentWelcome)
        }
        registerFragmentBinding.btnNavToLogin.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_fragmentRegister_to_fragmentLogin)
        }
        registerFragmentBinding.btnCreatingAccount.setOnClickListener { view: View ->
            if(registerFragmentBinding.edtUsernameInRegisterDisplay.text.toString().isEmpty() && registerFragmentBinding.edtPasswordInRegisterDisplay.text.toString().isEmpty()) {
                registerFragmentBinding.edtUsernameInRegisterDisplay.error = "Please enter your information !"
                registerFragmentBinding.edtUsernameInRegisterDisplay.requestFocus()
            }
            if(registerFragmentBinding.edtUsernameInRegisterDisplay.text.toString().isNotEmpty() && registerFragmentBinding.edtPasswordInRegisterDisplay.text.toString().isNotEmpty()) {
                firebaseUsersStore = FirebaseUsersStore()
                registerFragmentBinding.progressBarInRegister?.visibility = View.VISIBLE
                firebaseUsersStore.createNewUser(registerFragmentBinding.edtUsernameInRegisterDisplay.text.toString(), registerFragmentBinding.edtPasswordInRegisterDisplay.text.toString(), activity!!, view)
            }
            if(!Patterns.EMAIL_ADDRESS.matcher(registerFragmentBinding.edtUsernameInRegisterDisplay.text.toString()).matches()){
                registerFragmentBinding.edtUsernameInRegisterDisplay.error = "Please enter valid email !"
                registerFragmentBinding.edtUsernameInRegisterDisplay.requestFocus()
            }
        }
    }
}
