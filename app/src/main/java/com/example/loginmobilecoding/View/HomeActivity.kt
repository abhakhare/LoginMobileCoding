package com.example.loginmobilecoding.View

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.loginmobilecoding.R
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity :AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        var strUser: String? = intent.getStringExtra("Username")
        System.out.println(strUser)
        if (strUser != null) {

            textdetails.setText("Hello"+" "+strUser)
        }

    }
}