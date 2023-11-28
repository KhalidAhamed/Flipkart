package com.example.flipkart.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.flipkart.ModelClass.FirstRecModel
import com.example.flipkart.ModelClass.ThirdModelClass
import com.example.flipkart.R

class ThirdRecAdapter(val context: Context, var arrThirdRec : ArrayList<ThirdModelClass>) : RecyclerView.Adapter<ThirdRecAdapter.ViewHolder>() {
    class ViewHolder(itemView : View): RecyclerView.ViewHolder(itemView)  {
        val img = itemView.findViewById<ImageView>(R.id.thirdRecImg)
        val title = itemView.findViewById<TextView>(R.id.thirdRecText)
        val offer = itemView.findViewById<TextView>(R.id.thirdRecText2)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.third_rec_layout,parent,false))
    }

    override fun getItemCount(): Int {
        return arrThirdRec.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.img.setImageResource(arrThirdRec[position].img)
        holder.title.text = arrThirdRec[position].title
        holder.offer.text = arrThirdRec[position].offer
    }
}