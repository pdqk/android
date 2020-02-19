package com.example.cloneshopee.fireBase

import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import androidx.navigation.findNavController
import com.example.cloneshopee.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class FirebaseControlLogIn constructor() {
    private lateinit var auth: FirebaseAuth

    fun logIn(email: String, passwd: String, activity: FragmentActivity, view: View) {
        auth = FirebaseAuth.getInstance()
        auth.signInWithEmailAndPassword(email, passwd)
            .addOnCompleteListener(activity){task ->
                if(task.isSuccessful){
                    val user: FirebaseUser? = auth.currentUser
                    updateUI(user, activity,view)
                }else{
                    Log.e("error", "onComplete: Failed=" + task.exception?.message)
                    updateUI(null, activity,view)
                }
            }
    }

//    fun checkCurrentUser(activity: FragmentActivity, view: View){
//        auth = FirebaseAuth.getInstance()
//        val currentUser: FirebaseUser? = auth.currentUser
//        updateUI(currentUser, activity, view)
//    }

    private fun updateUI(currentUser: FirebaseUser?, activity: FragmentActivity,view: View){
        if(currentUser != null){
            if(currentUser.isEmailVerified){
                view.findNavController().navigate(R.id.action_fragmentLogin_to_fragmentGetStarted)
            }else{
                Toast.makeText(activity, "Please verify your email !", Toast.LENGTH_SHORT).show()
            }
        }else{
            Toast.makeText(activity, "Username not found. Please try again !", Toast.LENGTH_SHORT).show()
        }
    }
}