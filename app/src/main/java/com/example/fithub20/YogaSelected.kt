package com.example.fithub20

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class YogaSelected : AppCompatActivity() {
    private lateinit var backbtn: ImageView
    private lateinit var titleText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_yoga_selected)

        val recieveYoga = intent.getStringExtra("selectedExercise")
        val level = intent.getStringExtra("selectedlevel")

        //findViewById<TextView>(R.id.exerciseName).text = recieveYoga
        //backbtn = findViewById(R.id.back)
        titleText = findViewById(R.id.exerciseName)
        titleText.text = recieveYoga
        backbtn = findViewById(R.id.back)
        backbtn.setOnClickListener(){
            finish()
        }

    }
}