package com.example.cloneshopee.main.displayGetStarted


import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.cloneshopee.R
import com.example.cloneshopee.databinding.GetStartedDisplayBinding
import com.example.cloneshopee.home.HomeActivity

/**
 * A simple [Fragment] subclass.
 */
class FragmentGetStarted : Fragment() {
    private lateinit var getStartedFragmentBinding: GetStartedDisplayBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        getStartedFragmentBinding = DataBindingUtil.inflate(inflater, R.layout.get_started_display, container, false)

        getStartedFragmentBinding.buttonStart.setOnClickListener {
            val intent = Intent(activity, HomeActivity::class.java)
            startActivity(intent)
        }

        return getStartedFragmentBinding.root
    }


}
