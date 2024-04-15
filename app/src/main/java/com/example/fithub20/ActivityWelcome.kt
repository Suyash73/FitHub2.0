package com.example.fithub20

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class ActivityWelcome : AppCompatActivity() {

    private lateinit var g2login : Button
    private lateinit var g2register : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        g2login = findViewById(R.id.go2login)
        g2register = findViewById(R.id.go2register)

        g2login.setOnClickListener {
            val intent = Intent(this, ActivityLogin::class.java)
            startActivity(intent)
            overridePendingTransition(0,0)
        }

        g2register.setOnClickListener {
            val intent = Intent(this, ActivitySignUp::class.java)
            startActivity(intent)
            overridePendingTransition(0,0)
        }
    }
}