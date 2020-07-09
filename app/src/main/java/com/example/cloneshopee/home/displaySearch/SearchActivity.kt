package com.example.cloneshopee.home.displaySearch

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.example.cloneshopee.R
import com.example.cloneshopee.databinding.DisplaySearchBinding
import com.example.cloneshopee.home.coroutines.search.CoroutineSearchBackNavigation
import com.example.cloneshopee.home.viewModels.search.SearchViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job

class SearchActivity : AppCompatActivity() {
    private lateinit var displaySearchBinding: DisplaySearchBinding
    private lateinit var searchViewModel: SearchViewModel

    private val searchJob = Job()
    private val searchScope = CoroutineScope(searchJob + Dispatchers.Main)

    private val backNavigateJob = Job()
    private val backNavigateScope = CoroutineScope(backNavigateJob + Dispatchers.Main)
    private val coroutineSearchBackNavigation = CoroutineSearchBackNavigation()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        displaySearchBinding = DataBindingUtil.setContentView(this, R.layout.display_search)
        searchViewModel = ViewModelProviders.of(this).get(SearchViewModel::class.java)

        onSearching()
        navToHomePage()

        window.apply {
            clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
            statusBarColor = Color.TRANSPARENT
        }

    }

    private fun onSearching(){
        displaySearchBinding.imgvSearch.setOnClickListener {
            searchViewModel.onCoroutineGetResult(searchScope, this, displaySearchBinding)
        }
    }

    private fun navToHomePage(){
        coroutineSearchBackNavigation.onBackNavigating(backNavigateScope, this, displaySearchBinding)
    }

    override fun onStop() {
        super.onStop()
        searchViewModel.onDone(searchJob)
        coroutineSearchBackNavigation.onDone(backNavigateJob)
    }

    override fun onDestroy() {
        super.onDestroy()
        searchViewModel.onDone(searchJob)
        coroutineSearchBackNavigation.onDone(backNavigateJob)
    }
}
