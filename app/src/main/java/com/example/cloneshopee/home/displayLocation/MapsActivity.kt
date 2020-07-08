package com.example.cloneshopee.home.displayLocation

import android.content.Intent
import android.graphics.Color
import android.location.Geocoder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.example.cloneshopee.R
import com.example.cloneshopee.databinding.ActivityMapsBinding
import com.example.cloneshopee.home.HomeActivity
import com.example.cloneshopee.home.viewModels.dish.AllCartPriceViewModel
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.*
import java.util.*
import kotlin.collections.ArrayList


class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var activityMapsBinding: ActivityMapsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMapsBinding = DataBindingUtil.setContentView(this, R.layout.activity_maps)

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

        setupPrice()
        buttonControl()
    }

    override fun onMapReady(googleMap: GoogleMap) {
        val sharedPreferencesQuan = getSharedPreferences("CurrentQuan", 0)
        val Quan = sharedPreferencesQuan.getString("quan", "")
        val sharedPreferencesPhuong = getSharedPreferences("CurrentPhuong", 0)
        val Phuong = sharedPreferencesPhuong.getString("phuong", "")
        val sharedPreferences2 = getSharedPreferences("CurrentShop", 0)
        val shopaddress = sharedPreferences2.getString("shopaddress", "")
        val shopname = sharedPreferences2.getString("shopname", "")

        val geocoder = Geocoder(this, Locale.ENGLISH)
        val orderAddress = geocoder.getFromLocationName(Phuong+", "+Quan,1)
        val shopAddress = geocoder.getFromLocationName(shopaddress,1)

        val order = LatLng(orderAddress[0].latitude, orderAddress[0].longitude)
        val shop = LatLng(shopAddress[0].latitude, shopAddress[0].longitude)

        mMap = googleMap
        mMap.addMarker(MarkerOptions().position(order).title("Tôi"))
        mMap.addMarker(MarkerOptions().position(shop).title(shopname))
        val polyline = mMap.addPolyline(PolylineOptions()
            .clickable(true)
            .color(Color.BLUE).width(5f)
            .add(
                order,
                shop
            )
        )
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(order, 15f))
    }

    private fun setupPrice(){
        val sharedPreferences = getSharedPreferences("CurrentCart", 0)
        val cartprice = sharedPreferences.getLong("cartprice", 0)
        activityMapsBinding.txtvTongGiaMon.text = cartprice.toString()+"đ"

        val sum = cartprice + 3000 +15000
        activityMapsBinding.txtvTongTien.text = sum.toString()+"đ"
    }

    private fun buttonControl(){
        activityMapsBinding.btnDaNhanHang.setOnClickListener {
            val fm = supportFragmentManager
            val fragmentRating = FragmentRating()
            fragmentRating.show(fm, "TAG")
        }
    }
}
