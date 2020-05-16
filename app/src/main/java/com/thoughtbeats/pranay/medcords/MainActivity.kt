package com.thoughtbeats.pranay.medcords

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import android.content.Intent
import com.thoughtbeats.pranay.medcords.extensions.addFragment


class MainActivity : AppCompatActivity() {

    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                Toast.makeText(this,"Home",(Toast.LENGTH_SHORT)).show()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
                Toast.makeText(this,"Dashboard",(Toast.LENGTH_SHORT)).show()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
                Toast.makeText(this,"notifications",(Toast.LENGTH_SHORT)).show()
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        nav_view.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)
        addFragment(HomeFragment(),R.id.container)
    }
}
