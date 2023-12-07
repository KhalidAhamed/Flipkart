package com.example.flipkart.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.flipkart.Repository.PostsRepository

class PostsViewModelFactory(private val postsRepository: PostsRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return PostsViewModel(postsRepository) as T
    }
}