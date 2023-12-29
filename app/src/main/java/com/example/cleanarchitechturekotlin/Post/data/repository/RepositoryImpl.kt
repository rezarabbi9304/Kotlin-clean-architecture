package com.example.cleanarchitechturekotlin.Post.data.repository

import com.example.cleanarchitechturekotlin.Post.data.remote.api.PostApi
import com.example.cleanarchitechturekotlin.Post.domain.model.Post
import com.example.cleanarchitechturekotlin.Post.domain.repository.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

/**
 * @author Reza-e-rabbi
 */
class RepositoryImpl @Inject constructor(
    private val api: PostApi
): Repository {

    override suspend fun getPost(): Flow<List<Post>> = flow {
        emit(api.getPost())
    }.flowOn(Dispatchers.IO)
}