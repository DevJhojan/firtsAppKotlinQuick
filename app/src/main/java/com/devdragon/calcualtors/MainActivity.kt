package com.devdragon.calcualtors

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.content.Intent

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnIMCApp = findViewById<Button>(R.id.bntIMC)
        btnIMCApp.setOnClickListener{ navigateIMC() }
    }
    fun navigateIMC(){
        val startIMC = Intent(this, IMCActivity::class.java)
        startActivity(startIMC)
    }
}