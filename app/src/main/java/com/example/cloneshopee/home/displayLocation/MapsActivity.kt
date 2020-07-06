package com.example.cloneshopee.home.displayLocation

import android.graphics.Color
import android.location.Geocoder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.cloneshopee.R
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.*
import java.util.*
import kotlin.collections.ArrayList


class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
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
//        mMap.moveCamera(CameraUpdateFactory.newLatLng(order))
//        mMap.moveCamera(CameraUpdateFactory.newLatLng(shop))
//        mMap.animateCamera(CameraUpdateFactory.zoomTo(15.0f))

//        val options = PolylineOptions()
//        options.color(Color.BLUE)
//        options.width(5f)
        val polyline = mMap.addPolyline(PolylineOptions()
            .clickable(true)
            .color(Color.BLUE).width(5f)
            .add(
                order,
                shop
            )
        )
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(order, 14f))
    }
}
