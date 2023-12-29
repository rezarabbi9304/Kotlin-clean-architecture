package com.example.cleanarchitechturekotlin.Post.domain.repository
import com.example.cleanarchitechturekotlin.Post.domain.model.Post
import kotlinx.coroutines.flow.Flow

/**
 * @author reza-e-rabbi
 */
interface Repository {

    suspend fun getPost(): Flow<List<Post>>
}