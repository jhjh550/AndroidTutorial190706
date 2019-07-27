package com.example.laucher

import android.content.Intent
import android.content.pm.ResolveInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        myLauncherRecyclerView.layoutManager = LinearLayoutManager(this)
        setupAdapter()
    }

    fun setupAdapter(){
        val startIntent = Intent(Intent.ACTION_MAIN)
        val activities = packageManager.queryIntentActivities(startIntent, 0)
        Log.i("activities", "Found "+activities.size+" activities.")

        myLauncherRecyclerView.adapter = ActivityAdapter(activities)
    }

    inner class ActivityHolder(itemView: View)
        : RecyclerView.ViewHolder(itemView){

        lateinit var resolveInfo: ResolveInfo
        val myTextView = itemView as TextView

        fun bindActivity(info: ResolveInfo){
            resolveInfo = info
            val appName = resolveInfo.loadLabel(packageManager)
            myTextView.text = appName
        }
    }

    inner class ActivityAdapter(val activities: List<ResolveInfo>)
        : RecyclerView.Adapter<ActivityHolder>(){

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActivityHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(android.R.layout.simple_list_item_1, parent, false)
            return ActivityHolder(view)
        }

        override fun getItemCount(): Int {
            return activities.size
        }

        override fun onBindViewHolder(holder: ActivityHolder, position: Int) {
            holder.bindActivity(activities.get(position))
        }

    }

}
