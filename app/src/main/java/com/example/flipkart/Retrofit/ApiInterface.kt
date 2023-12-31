package com.example.flipkart.Retrofit

import com.example.flipkart.ModelClass.PostsModel
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {
    @GET("/posts")
    suspend fun getPosts() : Response<PostsModel>
}