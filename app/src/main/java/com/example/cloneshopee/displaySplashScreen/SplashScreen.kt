package com.example.cloneshopee.displaySplashScreen

import android.content.Context
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.WindowManager
import com.example.cloneshopee.R
import com.example.cloneshopee.home.HomeActivity
import com.example.cloneshopee.main.MainActivity
import java.lang.Exception

class SplashScreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_screen_display)

        window.apply {
            clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
            statusBarColor = Color.TRANSPARENT
        }

        splash()
        checkAccountWasRemembered()
    }

    private fun splash(){
        val background = object: Thread(){
            override fun run() {
                try {
                    Thread.sleep(2500)
                    val intent = Intent(baseContext, MainActivity::class.java)
                    startActivity(intent)
                }catch (e: Exception){
                    e.printStackTrace()
                }
            }
        }
        background.start()
    }

    private fun checkAccountWasRemembered(){
        val sharedPreferences = getSharedPreferences("checkbox", Context.MODE_PRIVATE)
        val checked = sharedPreferences.getString("rememberMe", "")
        if(checked.equals("true")){

        }else{
            Log.d("nothing", "nothing")
        }
    }
}
