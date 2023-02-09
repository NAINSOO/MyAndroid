package com.example.numbercounter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.numbercounter.databinding.ActivityMainBinding

var num = 0
class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.text.text = "$num"

        binding.init.setOnClickListener {
            num = 0
            binding.text.text = "$num"
        }

        binding.plus.setOnClickListener {
            num += 1
            binding.text.text = "$num"
        }
    }


}