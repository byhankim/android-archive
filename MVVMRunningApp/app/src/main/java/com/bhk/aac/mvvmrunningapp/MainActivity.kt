package com.bhk.aac.mvvmrunningapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bhk.aac.mvvmrunningapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).apply {
            setContentView(root)
        }
    }
}