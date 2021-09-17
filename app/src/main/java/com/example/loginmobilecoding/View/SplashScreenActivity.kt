package com.example.loginmobilecoding.View

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.loginmobilecoding.R

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashScreenActivity :AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splashscreen)
        lifecycleScope.launch {
            delay(2000)
            val intent= Intent(applicationContext,LoginActivity::class.java)
            startActivity(intent)
        }
    }
}