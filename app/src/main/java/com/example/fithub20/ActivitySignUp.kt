package com.example.fithub20

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class ActivitySignUp : AppCompatActivity() {
    private lateinit var registerMail : EditText
    private lateinit var pass1 : EditText
    private lateinit var pass2 : EditText
    private lateinit var signup : Button
    private lateinit var b2login : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        registerMail = findViewById(R.id.signupMail)
        pass1 = findViewById(R.id.signuppass)
        pass2 = findViewById(R.id.signupconfirm)
        signup = findViewById(R.id.signupbtn)
        b2login = findViewById(R.id.backtologin)

    }
}