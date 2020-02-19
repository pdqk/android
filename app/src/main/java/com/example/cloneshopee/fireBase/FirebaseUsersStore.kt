package com.example.cloneshopee.fireBase

import android.util.Log
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.FragmentActivity
import androidx.navigation.findNavController
import com.example.cloneshopee.R
import com.example.cloneshopee.main.MainActivity
import com.google.firebase.auth.FirebaseAuth

class FirebaseUsersStore constructor() {
    private lateinit var auth: FirebaseAuth

    fun createNewUser(email: String, passwd: String, activity: FragmentActivity, view: View) {
        auth = FirebaseAuth.getInstance()
        auth.createUserWithEmailAndPassword(email, passwd)
            .addOnCompleteListener(activity){ task ->
                if(task.isSuccessful){
                    val user = auth.currentUser
                    user?.sendEmailVerification()
                        ?.addOnCompleteListener { task ->
                            if (task.isSuccessful) {
                                view.findNavController().navigate(R.id.action_fragmentRegister_to_fragmentLogin)
                                Toast.makeText(activity, "Success !", Toast.LENGTH_SHORT).show()
                            }
                        }
                }else{
                    Log.e("error", "onComplete: Failed=" + task.exception?.message)
                }
        }
    }
}