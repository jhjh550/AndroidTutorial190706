package com.example.androidtutorialinkotlin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class MyRecyclerViewAdapter : RecyclerView.Adapter<MyRecyclerViewAdapter.MyViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.recycler_item_view, parent, false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return titles.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.apply {
            itemTitleTextView.text = titles[position]
            itemDetailTextView.text = details[position]
            itemImageView.setImageResource(images[position])
        }
    }

    val titles = arrayOf("chapter 1", "chapter 2", "chapter 3",
        "chapter 4", "chapter 5", "chapter 6","chapter 7")
    val details = arrayOf("detail 1", "detail 2", "detail 3",
        "detail 4", "detail 5", "detail 6", "detail 7")
    val images = arrayOf(R.drawable.ic_my_icon1,
        R.drawable.ic_my_icon2,
        R.drawable.ic_my_icon3,
        R.drawable.ic_my_icon1,
        R.drawable.ic_my_icon2,
        R.drawable.ic_my_icon3,
        R.drawable.ic_my_icon1)


    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val itemTitleTextView: TextView = itemView.findViewById(R.id.itemTitleTextView)
        val itemDetailTextView: TextView = itemView.findViewById(R.id.itemDetailTextView)
        val itemImageView: ImageView = itemView.findViewById(R.id.itemImageView)
    }


}