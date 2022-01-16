package com.walter.githubrepositories.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.walter.githubrepositories.R
import com.walter.githubrepositories.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}
