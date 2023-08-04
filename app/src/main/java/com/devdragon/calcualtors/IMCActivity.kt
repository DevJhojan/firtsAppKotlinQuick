package com.devdragon.calcualtors

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat

class IMCActivity : AppCompatActivity() {

    private var isMaleSelected:Boolean = true
    private var isFemaleSelected:Boolean = false
    private lateinit var viewMaleCard:CardView
    private lateinit var viewFemaleCard:CardView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_imcactivity)
        initComponents()
        initListeners()
        initUI()
    }


    private fun initComponents(){
        viewMaleCard = findViewById(R.id.viewMale)
        viewFemaleCard = findViewById(R.id.viewFemale)
    }

    private  fun initListeners(){
        viewMaleCard.setOnClickListener{
            changeGender()
            setGenderColor()
        }
        viewFemaleCard.setOnClickListener{
            changeGender()
            setGenderColor()
        }
    }
    private fun initUI(){
        setGenderColor()
    }
    private fun changeGender(){
        isMaleSelected = !isMaleSelected
        isFemaleSelected = !isFemaleSelected
    }
    private fun setGenderColor(){
        initUI()
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