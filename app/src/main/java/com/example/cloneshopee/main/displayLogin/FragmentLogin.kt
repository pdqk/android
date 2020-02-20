package com.example.cloneshopee.main.displayLogin

import android.content.Context.MODE_PRIVATE
import android.os.Bundle
import android.util.Patterns
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CompoundButton
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.cloneshopee.R
import com.example.cloneshopee.databinding.LoginDisplayBinding
import com.example.cloneshopee.fireBase.FirebaseControlLogIn

/**
 * A simple [Fragment] subclass.
 */
class FragmentLogin : Fragment() {
    private lateinit var loginFragmentBinding: LoginDisplayBinding
    private lateinit var firebaseControlLogIn: FirebaseControlLogIn

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        loginFragmentBinding = DataBindingUtil.inflate(inflater, R.layout.login_display, container, false)

        buttonControl()

        return loginFragmentBinding.root
    }

    private fun buttonControl(){
        loginFragmentBinding.txtvNavToRegister.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_fragmentLogin_to_fragmentRegister)
        }
        loginFragmentBinding.btnLoggingIn.setOnClickListener { view: View ->
            if(loginFragmentBinding.edtUsernameInLoginDisplay.text.toString().isEmpty() && loginFragmentBinding.edtPasswordInLoginDisplay.text.toString().isEmpty()){
                loginFragmentBinding.edtUsernameInLoginDisplay.error = "Please enter your information !"
                loginFragmentBinding.edtUsernameInLoginDisplay.requestFocus()
            }
            if(loginFragmentBinding.edtUsernameInLoginDisplay.text.toString().isNotEmpty() && loginFragmentBinding.edtPasswordInLoginDisplay.text.toString().isNotEmpty()){
                firebaseControlLogIn = FirebaseControlLogIn()
                loginFragmentBinding.progressBarInLogIn?.visibility = View.VISIBLE
                firebaseControlLogIn.logIn(loginFragmentBinding.edtUsernameInLoginDisplay.text.toString(), loginFragmentBinding.edtPasswordInLoginDisplay.text.toString(), activity!!, view)
            }
            if(!Patterns.EMAIL_ADDRESS.matcher(loginFragmentBinding.edtUsernameInLoginDisplay.text.toString()).matches()){
                loginFragmentBinding.edtUsernameInLoginDisplay.error = "Please enter valid email !"
                loginFragmentBinding.edtUsernameInLoginDisplay.requestFocus()
            }
        }
        loginFragmentBinding.txtvNavToForgot.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_fragmentLogin_to_fragmentForgotPassword)
        }
        loginFragmentBinding.switchToRememberPass.setOnCheckedChangeListener{buttonView: CompoundButton?, isChecked: Boolean ->
            if(isChecked){
                val sharedPreferences = activity!!.getSharedPreferences("checkbox", MODE_PRIVATE)
                val editor = sharedPreferences.edit()
                editor.putString("rememberMe", "true")
                editor.apply()
            }else{
                val sharedPreferences = activity!!.getSharedPreferences("checkbox", MODE_PRIVATE)
                val editor = sharedPreferences.edit()
                editor.putString("rememberMe", "false")
                editor.apply()
            }
        }
    }

}
