package com.example.flipkart.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.flipkart.ModelClass.FirstRecModel
import com.example.flipkart.ModelClass.SecondRecModel
import com.example.flipkart.R

class SecondRecAdapter(val context: Context, var arrSecondtRec : ArrayList<SecondRecModel>) : RecyclerView.Adapter<SecondRecAdapter.ViewHolder>() {
    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        val img = itemView.findViewById<ImageView>(R.id.secondRecImg)
        val text = itemView.findViewById<TextView>(R.id.secondRecText)
        val text2 = itemView.findViewById<TextView>(R.id.secondRecText2)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       return ViewHolder(LayoutInflater.from(context).inflate(R.layout.second_rec_layout, parent, false))
    }

    override fun getItemCount(): Int {
        return arrSecondtRec.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.img.setImageResource(arrSecondtRec[position].img)
        holder.text.text = arrSecondtRec[position].text
        holder.text2.text = arrSecondtRec[position].text2
    }
}