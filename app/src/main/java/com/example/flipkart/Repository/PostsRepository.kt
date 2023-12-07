package com.example.flipkart.Repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.flipkart.ModelClass.PostsModel
import com.example.flipkart.Retrofit.ApiInterface

class PostsRepository(private val apiInterface: ApiInterface) {
    private val postsLiveData = MutableLiveData<PostsModel>()
    val posts : LiveData<PostsModel>
        get() = postsLiveData


    suspend fun getPosts(){
        val result = apiInterface.getPosts()
        if (result.isSuccessful){
            postsLiveData.postValue(result.body())
            Log.e("result",result.body().toString())
        }
    }
}