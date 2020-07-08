package com.example.cloneshopee.home.displayFavorite


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.cloneshopee.R
import com.example.cloneshopee.databinding.FavoriteDisplayBinding

/**
 * A simple [Fragment] subclass.
 */
class FragmentFavorite : Fragment() {
    private lateinit var favoriteDisplayBinding: FavoriteDisplayBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        favoriteDisplayBinding = DataBindingUtil.inflate(inflater, R.layout.favorite_display, container, false)



        return favoriteDisplayBinding.root
    }


}
