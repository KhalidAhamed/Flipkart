package com.example.flipkart.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.flipkart.ModelClass.PostsModel
import com.example.flipkart.R

class PostsAdapter(val context: Context, val postsArr : PostsModel) : RecyclerView.Adapter<PostsAdapter.ViewHolder>() {

    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val id = itemView.findViewById<TextView>(R.id.id)
        val title = itemView.findViewById<TextView>(R.id.title)
        val body = itemView.findViewById<TextView>(R.id.body)

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostsAdapter.ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.posts_recycler_view,parent,false))
    }

    override fun onBindViewHolder(holder: PostsAdapter.ViewHolder, position: Int) {
       holder.id.text = postsArr[position].id.toString()
        holder.title.text = postsArr[position].title
        holder.body.text = postsArr[position].body
    }

    override fun getItemCount(): Int {
        return postsArr.size
    }
}