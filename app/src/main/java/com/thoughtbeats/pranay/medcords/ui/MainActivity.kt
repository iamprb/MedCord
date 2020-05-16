package com.thoughtbeats.pranay.medcords.ui

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.thoughtbeats.pranay.medcords.R
import kotlinx.android.synthetic.main.activity_main.*
import com.thoughtbeats.pranay.medcords.extensions.addFragment


class MainActivity : AppCompatActivity() {

    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
                Toast.makeText(this,getString(R.string.title_dashboard),(Toast.LENGTH_SHORT)).show()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
                Toast.makeText(this,getString(R.string.title_notifications),(Toast.LENGTH_SHORT)).show()
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        nav_view.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)
        addFragment(HomeFragment(), R.id.container)
    }
}
