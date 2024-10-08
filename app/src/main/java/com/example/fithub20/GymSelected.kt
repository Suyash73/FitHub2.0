package com.example.fithub20

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class GymSelected : AppCompatActivity() {

    private lateinit var backbtn: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gym_selected)
        val recieveExercise = intent.getStringExtra("selectedExercise")
        val level = intent.getStringExtra("selectedlevel")

        findViewById<TextView>(R.id.exerciseName).text = recieveExercise
        backbtn = findViewById(R.id.back)
        backbtn.setOnClickListener(){
            finish()
        }
    }

}