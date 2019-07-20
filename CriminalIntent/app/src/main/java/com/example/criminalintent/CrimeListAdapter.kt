package com.example.criminalintent

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class CrimeListAdapter : RecyclerView.Adapter<CrimeListAdapter.CrimeViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CrimeViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_crime_item, parent, false)
        return CrimeViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return CrimeLab.crimes.size
    }

    override fun onBindViewHolder(holder: CrimeViewHolder, position: Int) {
        holder.bindCrime(CrimeLab.crimes[position])
    }

    class CrimeViewHolder(itemView: View): RecyclerView.ViewHolder(itemView), View.OnClickListener{
        lateinit var crime: Crime
        val checkBoxCrimeSolved: CheckBox = itemView.findViewById(R.id.checkBoxCrimeSolved)
        val textViewCrimeTitle: TextView = itemView.findViewById(R.id.textViewCrimeTitle)
        val textViewCrimeDate: TextView = itemView.findViewById(R.id.textViewCrimeDate)
        init {
            itemView.setOnClickListener(this)
        }

        fun bindCrime(param: Crime){
            crime = param
            checkBoxCrimeSolved.isChecked = crime.solved
            textViewCrimeTitle.text = crime.title
            textViewCrimeDate.text = crime.date.toString()
        }
        override fun onClick(view: View?) {
//            Toast.makeText(itemView.context, crime.title+" clicked",
//                Toast.LENGTH_SHORT).show()
            val intent = CrimeActivity.newIntent(itemView.context, crime.uuid)
            itemView.context.startActivty(intent)
        }

    }
}