package com.example.flipkart.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.flipkart.ModelClass.PostsModel
import com.example.flipkart.Repository.PostsRepository
import kotlinx.coroutines.launch

class PostsViewModel(private val postsRepository: PostsRepository) : ViewModel() {
    init {
        viewModelScope.launch {
           postsRepository.getPosts()
        }
    }
    val posts : LiveData<PostsModel>
        get() = postsRepository.posts

}