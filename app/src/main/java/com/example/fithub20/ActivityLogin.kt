package com.example.fithub20

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class ActivityLogin : AppCompatActivity() {

    private lateinit var login: Button
    private lateinit var newAcc : Button
    private lateinit var password: EditText
    private lateinit var mail : EditText
    private lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        login = findViewById(R.id.loginbtn)
        newAcc = findViewById(R.id.registerbtn)
        mAuth = FirebaseAuth.getInstance()

        password = findViewById(R.id.loginpass)
        mail = findViewById(R.id.loginmail)

        newAcc.setOnClickListener {
            val intent = Intent(this, ActivitySignUp::class.java)
            startActivity(intent)
            overridePendingTransition(0,0)
        }

        login.setOnClickListener {
            val email = mail.text.toString()
            val pswd = password.text.toString()

            login(email, pswd)
        }

    }
    private fun login(email: String, password: String) {
        mAuth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    val intent = Intent(this@ActivityLogin, GymActivity::class.java)
                    finish()
                    startActivity(intent)
                } else {
                    Toast.makeText(this@ActivityLogin, "Some Error Occurred", Toast.LENGTH_SHORT).show()
                }
            }
    }
}