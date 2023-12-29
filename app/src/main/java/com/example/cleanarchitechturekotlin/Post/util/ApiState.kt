package com.example.cleanarchitechturekotlin.Post.util

import com.example.cleanarchitechturekotlin.Post.domain.model.Post


sealed class ApiState{

    class Success(val data:List<Post> ) : ApiState()
    class Failure(val msg:Throwable) : ApiState()
    object Loading : ApiState()
    object Empty : ApiState()

}