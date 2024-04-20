package com.example.fithub20

import android.app.Activity
import android.content.Intent
import android.content.res.Resources
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView

class GymAdapter(val context: Activity, val exerciseList: List<GymExerciseData>):
    RecyclerView.Adapter<GymAdapter.ViewHolder>(){
    var exercisePosition = -1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GymAdapter.ViewHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.gym_item,parent,false)
        return GymAdapter.ViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return exerciseList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentExercise = exerciseList[position]
        holder.title.text = currentExercise.name
        holder.level.text = currentExercise.level

        val resources: Resources = context.resources
        val resourceId: Int = resources.getIdentifier(currentExercise.imge, "drawable", context.packageName)
        holder.image.setImageResource(resourceId)

        holder.itemView.setOnClickListener(){
            val intent = Intent(context, GymSelected::class.java)
            intent.putExtra("selectedExercise", currentExercise.name)
            intent.putExtra("selectedlevel", currentExercise.level)
            context.startActivity(intent)
        }
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val image: ImageView = itemView.findViewById(R.id.gitemImg)
        val title: TextView = itemView.findViewById(R.id.gTitle)
        val level: TextView = itemView.findViewById(R.id.gLevel)
    }
}