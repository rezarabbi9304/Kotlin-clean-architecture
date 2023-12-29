package com.example.cleanarchitechturekotlin.Post.data.remote.api

import com.example.cleanarchitechturekotlin.Post.domain.model.Post
import retrofit2.http.GET

/**
 * @author Reza-e-rabbi
 */
interface PostApi {

    @GET("posts")
    suspend fun getPost():List<Post>
}