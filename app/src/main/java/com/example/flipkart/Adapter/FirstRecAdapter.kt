package com.example.flipkart.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.flipkart.ModelClass.FirstRecModel
import com.example.flipkart.R

class FirstRecAdapter(val context: Context,var arrFirstRec : ArrayList<FirstRecModel>) : RecyclerView.Adapter<FirstRecAdapter.ViewHolder>() {
    class ViewHolder(itemView :View) : RecyclerView.ViewHolder(itemView) {
        val img = itemView.findViewById<ImageView>(R.id.round_image)
        val title = itemView.findViewById<TextView>(R.id.title)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.first_rec_layout,parent,false))
    }

    override fun getItemCount(): Int {
        return arrFirstRec.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       holder.title.text = arrFirstRec[position].title
        arrFirstRec[position].image?.let { holder.img.setImageResource(it) }
    }
}