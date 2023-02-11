package com.example.unitconvertor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.core.text.isDigitsOnly
import androidx.core.widget.addTextChangedListener
import com.example.unitconvertor.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private var isCmtom = true
    private var inputText:String = ""
    private var outputText:String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if(savedInstanceState != null){
            inputText = savedInstanceState.getString("inputText").toString()
            outputText = savedInstanceState.getString("outputText").toString()
            isCmtom = savedInstanceState.getBoolean("isCmtom")
            Log.d("sdsfdsdf","$inputText $outputText $isCmtom")
            if(isCmtom) {
                binding.unit1.text = "cm"
                binding.unit2.text = "m"
            }else{
                binding.unit1.text = "m"
                binding.unit2.text = "cm"
            }

        }


        binding.imgButton.setOnClickListener{
            if(isCmtom) {
                isCmtom = false
                binding.unit1.text = "m"
                binding.unit2.text = "cm"
            }else{
                isCmtom = true
                binding.unit1.text = "cm"
                binding.unit2.text = "m"
            }

            if(inputText.isEmpty()){
                binding.text.text = "0"
            }else if(!inputText.isDigitsOnly()){
                binding.text.text = "잘못된 값"
            }else {
                outputText = if(isCmtom){
                    (inputText.toFloat() / 100).toString()
                }else{
                    (inputText.toInt() * 100).toString()
                }
                binding.text.text = outputText
            }
        }
        
        binding.edit.addTextChangedListener {
            inputText = it.toString()

            if(inputText.isEmpty()){ // EditText가 비었을 때 text값이 null이 아니다.
                binding.text.text = "0"
                return@addTextChangedListener
            }else if(!inputText.isDigitsOnly()){
                binding.text.text = "잘못된 값"
                return@addTextChangedListener
            }

            outputText = if(isCmtom){
                (inputText.toFloat() / 100).toString()
            }else{
                (inputText.toInt() * 100).toString()
            }

            binding.text.text = outputText
        }


    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        outState.putString("inputText", inputText)
        outState.putString("outputText", outputText)
        outState.putBoolean("isCmtom", isCmtom)
    }
}