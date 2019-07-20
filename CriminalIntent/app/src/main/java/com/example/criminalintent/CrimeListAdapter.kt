package com.example.criminalintent

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class CrimeListAdapter : RecyclerView.Adapter<CrimeListAdapter.CrimeViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CrimeViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_crime_item, parent, false)
        return CrimeViewHolder(itemView)
    }

    override fun getItemCount(): Int {
    }

    override fun onBindViewHolder(holder: CrimeViewHolder, position: Int) {
    }

    class CrimeViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

    }
}