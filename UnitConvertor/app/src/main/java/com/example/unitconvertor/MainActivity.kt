package com.example.unitconvertor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.core.text.isDigitsOnly
import androidx.core.widget.addTextChangedListener
import com.example.unitconvertor.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    var isCmtom = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.imgButton.setOnClickListener{
            val str : String = binding.edit.text.toString()
            if(isCmtom){
                isCmtom = false
                binding.unit1.text = "m"
                binding.unit2.text = "cm"
                binding.text.text = (str.toInt() * 100).toString()
            }else{
                isCmtom = true
                binding.unit1.text = "cm"
                binding.unit2.text = "m"
                binding.text.text = (str.toFloat() / 100).toString()
            }
        }

        binding.edit.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                val str : String? = binding.edit.text?.toString()

                if(str == null){
                    binding.edit.setText("0")
                    binding.text.text = "0"
                    return
                }else if(!str.isDigitsOnly()){
                    binding.edit.setText("0")
                    return
                }

                if(isCmtom){
                    binding.text.text = (str.toFloat() / 100).toString()
                }else{
                    binding.text.text = (str.toInt() * 100).toString()
                }

            }

            override fun afterTextChanged(p0: Editable?) {
            }

        })

    }
}