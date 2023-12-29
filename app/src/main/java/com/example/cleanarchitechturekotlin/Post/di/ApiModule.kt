package com.example.cleanarchitechturekotlin.Post.di

import com.example.cleanarchitechturekotlin.Post.data.remote.api.PostApi
import com.example.cleanarchitechturekotlin.Post.data.repository.RepositoryImpl
import com.example.cleanarchitechturekotlin.Post.domain.repository.Repository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Named
import javax.inject.Singleton


/**
 * @author Reza-e-rabbi
 */
@Module
@InstallIn(SingletonComponent::class)
object ApiModule {

    @Provides
    @Singleton
    fun provideSomeApi(retrofit: Retrofit):PostApi{
        return  retrofit.create(PostApi::class.java)
    }


}