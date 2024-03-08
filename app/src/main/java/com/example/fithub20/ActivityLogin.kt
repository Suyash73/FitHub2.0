package com.example.fithub20

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class ActivityLogin : AppCompatActivity() {

    private lateinit var login: Button
    private lateinit var frgbtn : Button
    private lateinit var newAcc : Button
    private lateinit var password: EditText
    private lateinit var mail : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        login = findViewById(R.id.loginbtn)
        newAcc = findViewById(R.id.registerbtn)
        frgbtn = findViewById(R.id.forgotbtn)

        password = findViewById(R.id.loginpass)
        mail = findViewById(R.id.loginmail)


    }
}