package com.example.aspenperform.presentation.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.aspenperform.R
import com.example.aspenperform.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        binding?.btnExplore?.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .add(R.id.frameContainer, ListCountryFragment()).commit()
        }
    }
}