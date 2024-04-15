package com.example.fithub20

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.firestore.auth.User

class ActivitySignUp : AppCompatActivity() {
    private lateinit var registerMail : EditText
    private lateinit var pass1 : EditText
    private lateinit var pass2 : EditText
    private lateinit var signup : Button
    private lateinit var b2login : Button
    private lateinit var mAuth: FirebaseAuth
    private lateinit var mDbRef: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        registerMail = findViewById(R.id.signupMail)
        pass1 = findViewById(R.id.signuppass)
        pass2 = findViewById(R.id.signupconfirm)
        signup = findViewById(R.id.signupbtn)
        b2login = findViewById(R.id.backtologin)
        mAuth = FirebaseAuth.getInstance()

        b2login.setOnClickListener {
            val intent = Intent(this, ActivityLogin::class.java)
            startActivity(intent)
            overridePendingTransition(0,0)
        }

        signup.setOnClickListener {
            val email = registerMail.text.toString()
            val pswd1 = pass1.text.toString()
            val pswd2 = pass2.text.toString()

            if(email.isEmpty() or pswd2.isEmpty() or pswd1.isEmpty()){
                Toast.makeText(this,"Fill all details", Toast.LENGTH_SHORT).show()
            }else if(pswd1 != pswd2){
                Toast.makeText(this,"Password not matching", Toast.LENGTH_SHORT).show()
            }else{
                signUp(email, pswd1)
            }


        }

    }

    private fun signUp(email: String, password: String) {
        mAuth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    addUserToDatabase(email, mAuth.currentUser?.uid!!)
                    val intent = Intent(this@ActivitySignUp, GymActivity::class.java)
                    finish()
                    startActivity(intent)
                } else {
                    Toast.makeText(this@ActivitySignUp, "Some Error Occurred", Toast.LENGTH_SHORT).show()
                }

            }
    }
    private fun addUserToDatabase(email: String, uid: String) {
        mDbRef = FirebaseDatabase.getInstance().getReference()
        mDbRef.child("user").child(uid).setValue(User(email, uid))
    }
}