package com.example.wcalculator.imc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import com.example.wcalculator.R
import com.google.android.material.slider.RangeSlider
import java.text.DecimalFormat

class ImcActivity : AppCompatActivity() {

    private var isMaleSelected:Boolean = true
    private var isFemaleSelected:Boolean = false
    private lateinit var viewMaleCard: CardView
    private lateinit var viewFemaleCard:CardView
    private lateinit var tvHeightText:TextView
    private lateinit var rsHeightRange: RangeSlider
    private lateinit var viewPesoSumCard:CardView
    private lateinit var viewPesoRestCard:CardView
    private lateinit var viewAgeSumCard:CardView
    private lateinit var viewAgeRestCard:CardView
    private lateinit var tvPesoText:TextView
    private lateinit var tvAgeText: TextView
    private lateinit var tvIMCResultText: TextView
    private lateinit var btnIMCCalcutaorButton: Button
    var valuePeso:Float = 0f
    var valueAge:Int = 0
    var valueHighInt:Float = 0f
    var IMCResult:Float = 0f
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_imc)
        initComponents()
        initListeners()
    }

    private fun initComponents(){
        viewMaleCard = findViewById(R.id.viewMale)
        viewFemaleCard = findViewById(R.id.viewFemale)
        tvHeightText = findViewById(R.id.tvHeight)
        rsHeightRange = findViewById(R.id.rsHeight)
        viewPesoSumCard = findViewById(R.id.btnSumPeso)
        viewPesoRestCard = findViewById(R.id.btnRestPeso)
        viewAgeRestCard = findViewById(R.id.btnRestAge)
        viewAgeSumCard = findViewById(R.id.btnSumAge)
        tvPesoText = findViewById(R.id.tvPeso)
        tvAgeText = findViewById(R.id.tvAge)
        tvIMCResultText = findViewById(R.id.tvIMCResult)
        btnIMCCalcutaorButton = findViewById<Button>(R.id.btnCalculatorIMC)
    }

    private  fun initListeners(){
        btnIMCCalcutaorButton.setOnClickListener{
            cacutatorIMC()
        }
        viewPesoRestCard.setOnClickListener{
            restPeso()
        }
        viewPesoSumCard.setOnClickListener{
            sumPeso()
        }
        viewAgeRestCard.setOnClickListener{
            restAge()
        }
        viewAgeSumCard.setOnClickListener{
            sumAge()
        }
        viewMaleCard.setOnClickListener{
            changeGender()
            setGenderColor()
        }
        viewFemaleCard.setOnClickListener{
            changeGender()
            setGenderColor()
        }
        rsHeightRange.addOnChangeListener { _, value, _ ->
            valueHighInt = value
            val df = DecimalFormat("##.##")
            val result = df.format(value)
            tvHeightText.text =  "$result m"
        }
    }

    private fun cacutatorIMC() {
        val df = DecimalFormat("##.##")
        IMCResult =   valuePeso / (valueHighInt * valueHighInt)
        val resultIMC = df.format(IMCResult)
        tvIMCResultText.text = "IMC: $resultIMC"

    }

    private fun sumAge() {
        valueAge += 1
        tvAgeText.text = "$valueAge"
    }

    private fun restAge() {
        valueAge -= 1
        tvAgeText.text = "$valueAge"
    }

    private fun restPeso() {
        val df = DecimalFormat("##.#")
        valuePeso -= 1
        val result = df.format(valuePeso)
        tvPesoText.text = "$result kl"
    }

    private fun sumPeso() {
        val df = DecimalFormat("##.#")
        valuePeso += 1
        val result = df.format(valuePeso)
        tvPesoText.text = "$result kl"
    }

    private fun changeGender(){
        isMaleSelected = !isMaleSelected
        isFemaleSelected = !isFemaleSelected
    }
    private fun setGenderColor(){
        viewMaleCard.setCardBackgroundColor(getBacgroundColorCard(isMaleSelected))
        viewFemaleCard.setCardBackgroundColor(getBacgroundColorCard(isFemaleSelected))
    }

    private fun getBacgroundColorCard(isSelectedCard:Boolean): Int{
        val cardColor = if(isSelectedCard)
        {
            R.color.Background_Component_Select_IMC
        }else{
            R.color.Background_Component_IMC
        }
        return ContextCompat.getColor(this,cardColor)
    }
}