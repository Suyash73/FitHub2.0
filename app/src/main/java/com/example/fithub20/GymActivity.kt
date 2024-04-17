package com.example.fithub20

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView

class GymActivity : AppCompatActivity() {

    private var initialX: Float = 0f
    private lateinit var gymAdapter: GymAdapter
    private lateinit var gymrecyclerView: RecyclerView
    private lateinit var bottomNavigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val exerciseList = listOf(
            GymExerciseData("gym_poster_pushup","Push-Ups","Chest, Shoulder"),
            GymExerciseData("gym_poster_squat","Squats","Quadriceps"),
            GymExerciseData("gym_poster_dumbellcurl","Dumbbell Curls","Biceps")
        )
        gymrecyclerView = findViewById(R.id.gym_item)
        gymAdapter = GymAdapter(this,exerciseList)
        gymrecyclerView.adapter = gymAdapter
        gymrecyclerView.layoutManager = LinearLayoutManager(this)

        findViewById<View>(android.R.id.content).setOnTouchListener { _, event ->
            handleTouchEvent(event)
        }

        bottomNavigationView = findViewById(R.id.bottomNav)
        bottomNavigationView.setSelectedItemId(R.id.idGym)

        bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.idYoga -> {
                    val a = Intent(this@GymActivity, YogaActivity::class.java)
                    startActivity(a)
                    overridePendingTransition(0,0)
                }
                R.id.idBot -> {
                    //val a = Intent(this@YogaActivity, SongSearch::class.java)
                    //startActivity(a)
                    //overridePendingTransition(0,0)
                }
                R.id.idProfile -> {
                    //val b = Intent(this@YogaActivity, Chats::class.java)
                    //startActivity(b)
                    //overridePendingTransition(0,0)
                }
            }
            false
        }




    }

    private fun handleTouchEvent(event: MotionEvent): Boolean {
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                // Save the initial touch position
                initialX = event.x
                return true
            }
            MotionEvent.ACTION_UP -> {
                // Check if there was a significant horizontal swipe
                val deltaX = event.x - initialX
                if (deltaX > SWIPE_THRESHOLD) {
                    // Right swipe detected, perform your action here
                    performAction()
                }
                return true
            }
        }
        return false
    }

    private fun performAction() {
        // Replace this with the action you want to perform on a right swipe
        Toast.makeText(this, "Right swipe action performed!", Toast.LENGTH_SHORT).show()
        val a = Intent(this@GymActivity, YogaActivity::class.java)
        startActivity(a)
        overridePendingTransition(0,0)
    }

    companion object {
        private const val SWIPE_THRESHOLD = 200
    }
}