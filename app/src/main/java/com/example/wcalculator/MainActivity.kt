package com.example.wcalculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.example.wcalculator.calculator.calculatorActivity
import com.example.wcalculator.imc.ImcActivity

class MainActivity : AppCompatActivity() {
    private lateinit var btnIMCApp:Button
    private lateinit var btnCalculatorApp: Button
    private lateinit var btnDivisesApp:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initCompoent()
        initListeners()
    }

    private fun initListeners() {
        btnIMCApp.setOnClickListener{ navigateIMC() }
        btnCalculatorApp.setOnClickListener{navigateCalculator()}
    }

    private fun navigateCalculator() {
        val startCalculator = Intent(this, calculatorActivity::class.java)
        startActivity(startCalculator)
    }

    private fun initCompoent() {
        btnIMCApp = findViewById<Button>(R.id.btnIMC)
        btnCalculatorApp = findViewById<Button>(R.id.btnCalculator)
        btnDivisesApp =findViewById<Button>(R.id.btnConverson)
    }

    private fun navigateIMC() {
        val startIMC = Intent(this, ImcActivity::class.java)
        startActivity(startIMC)
    }
}