package com.example.fithub20

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class YogaActivity : AppCompatActivity() {

    private lateinit var yogaAdapter: YogaAdapter
    private lateinit var yogarecyclerView: RecyclerView
    private var initialX: Float = 0f

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_yoga)
        val exerciseList = listOf(
            YogaExerciseData("yoga_poster_treepose","Tree Pose","Quadriceps"),
            YogaExerciseData("yoga_poster_warrior","Warrior","Quadriceps, Hamstrings"),
            YogaExerciseData("yoga_poster_meditation","Beginner Meditation","Inner Peace")
        )
        yogarecyclerView = findViewById(R.id.gym_item)
        yogaAdapter = YogaAdapter(this,exerciseList)
        yogarecyclerView.adapter = yogaAdapter
        yogarecyclerView.layoutManager = LinearLayoutManager(this)
        findViewById<View>(android.R.id.content).setOnTouchListener { _, event ->
            handleTouchEvent(event)
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
        val a = Intent(this@YogaActivity, GymActivity::class.java)
        startActivity(a)
        overridePendingTransition(0,0)
    }

    companion object {
        private const val SWIPE_THRESHOLD = 200
    }
}