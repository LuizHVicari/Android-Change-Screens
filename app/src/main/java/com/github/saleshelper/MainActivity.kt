package com.github.saleshelper

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var btLaunch : Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initBtLaunch()


    }

    private fun initBtLaunch() {
        btLaunch = findViewById(R.id.btLaunch)
        btLaunch.setOnClickListener{
            btLaunchOnClick()
        }
    }

    private fun btLaunchOnClick() {
        val intent = Intent(this, SaleLaunchActivity::class.java)
        startActivity(intent)
    }
}