package com.example.cloneshopee.home.displayMe


import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.cloneshopee.R
import com.example.cloneshopee.databinding.MeDisplayBinding
import com.example.cloneshopee.main.MainActivity

/**
 * A simple [Fragment] subclass.
 */
class FragmentMe : Fragment() {
    private lateinit var meDisplayBinding: MeDisplayBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        meDisplayBinding = DataBindingUtil.inflate(inflater, R.layout.me_display, container, false)

        buttonControl()

        return meDisplayBinding.root
    }

    private fun buttonControl(){
        meDisplayBinding.btnDangXuat.setOnClickListener { view: View ->
            val intent = Intent(activity, MainActivity::class.java)
            val sharedPreferences = activity!!.getSharedPreferences("checkbox", Context.MODE_PRIVATE)
            val editor = sharedPreferences.edit()
            editor.remove("rememberMe")
            editor.apply()
            startActivity(intent)
        }

        meDisplayBinding.txtvNavToUngdungchuquan.setOnClickListener {
            val intent = activity!!.applicationContext.packageManager.getLaunchIntentForPackage("com.example.storeapplication")
            val sharedPreferences = activity!!.getSharedPreferences("CurrentUser", 0)
            val currentUser = sharedPreferences.getString("currentuser", "")
            if(intent != null){
                intent.putExtra("test", currentUser)
                startActivity(intent)
                activity!!.finish()
            }else{
                Log.i("Death","Error when lauching")
            }
        }
    }
}
