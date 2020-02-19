package com.example.cloneshopee.fireBase

import android.view.View
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import androidx.navigation.findNavController
import com.example.cloneshopee.R
import com.google.firebase.auth.FirebaseAuth

class FirebaseResetPasswdManager {
    private lateinit var auth: FirebaseAuth

    fun resetPassword(email: String, activity: FragmentActivity, view: View){
        auth = FirebaseAuth.getInstance()
        auth.sendPasswordResetEmail(email)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    view.findNavController().navigate(R.id.action_fragmentForgotPassword_to_fragmentLogin)
                    Toast.makeText(activity, "Email was sent!", Toast.LENGTH_SHORT).show()
                }else{
                    Toast.makeText(activity, "Failed! Try again.", Toast.LENGTH_SHORT).show()
                }
            }
    }
}