package com.example.cloneshopee.main.displayForgotPassword


import android.os.Bundle
import android.util.Patterns
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.cloneshopee.R
import com.example.cloneshopee.databinding.ForgotPasswordDisplayBinding
import com.example.cloneshopee.fireBase.FirebaseResetPasswdManager

/**
 * A simple [Fragment] subclass.
 */
class FragmentForgotPassword : Fragment() {
    private lateinit var forgotPasswordFragmentBinding: ForgotPasswordDisplayBinding
    private lateinit var firebaseResetPasswdManager: FirebaseResetPasswdManager

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        forgotPasswordFragmentBinding = DataBindingUtil.inflate(inflater, R.layout.forgot_password_display, container, false)

        buttonControl()

        return forgotPasswordFragmentBinding.root
    }

    private fun buttonControl(){
        forgotPasswordFragmentBinding.btnBackToLogin.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_fragmentForgotPassword_to_fragmentLogin)
        }
        forgotPasswordFragmentBinding.btnSendRequestResetPasswd.setOnClickListener { view: View ->
            if(forgotPasswordFragmentBinding.edtUsernameInForgotPasswordDisplay.text.toString().isEmpty()){
                forgotPasswordFragmentBinding.edtUsernameInForgotPasswordDisplay.error = "Please enter your email!"
                forgotPasswordFragmentBinding.edtUsernameInForgotPasswordDisplay.requestFocus()
            }
            if(!Patterns.EMAIL_ADDRESS.matcher(forgotPasswordFragmentBinding.edtUsernameInForgotPasswordDisplay.text.toString()).matches()){
                forgotPasswordFragmentBinding.edtUsernameInForgotPasswordDisplay.error = "Please enter valid email"
                forgotPasswordFragmentBinding.edtUsernameInForgotPasswordDisplay.requestFocus()
            }else{
                firebaseResetPasswdManager = FirebaseResetPasswdManager()
                firebaseResetPasswdManager.resetPassword(forgotPasswordFragmentBinding.edtUsernameInForgotPasswordDisplay.text.toString(), activity!!, view)
                forgotPasswordFragmentBinding.progressBarInForgotPassword?.visibility = View.VISIBLE
            }
        }
    }
}
