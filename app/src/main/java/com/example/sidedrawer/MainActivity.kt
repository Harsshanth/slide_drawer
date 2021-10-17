package com.example.sidedrawer

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        val navView : NavigationView = findViewById(R.id.nav_menu)

        val toggle = ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open,R.string.close)
        toggle.isDrawerIndicatorEnabled = true
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        navView.setNavigationItemSelectedListener {
            return@setNavigationItemSelectedListener when(it.itemId){
                R.id.account -> {
                    drawerLayout.closeDrawer(GravityCompat.START)
                    val intent : Intent = Intent(this,AccountActivity::class.java)
                    startActivity(intent)
                    true
                }
                R.id.about ->  {
                    val intent : Intent = Intent(this,AboutActivity::class.java)
                    startActivity(intent)
                    true
                }
                else -> false

            }

        }

    }


}