package com.example.cleanarchitechturekotlin.Post.presentation

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cleanarchitechturekotlin.Post.domain.repository.Repository
import com.example.cleanarchitechturekotlin.Post.util.ApiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * @author Reza-e-rabbi
 */
@HiltViewModel
class PostViewModel @Inject constructor(
    private val repository: Repository,
) : ViewModel() {

    val response: MutableState<ApiState> = mutableStateOf(ApiState.Empty)


    init {

    }

    fun getRequest(){
        viewModelScope.launch {
            repository.getPost(). onStart {
                response.value = ApiState.Loading
                Log.d("dekha", "Loading: "+ApiState.Loading)
            }.catch {
                response.value = ApiState.Failure(it)
                Log.d("dekha", ": failure"+ApiState.Failure(it))

            }.collect {
                response.value = ApiState.Success(it)
                Log.d("dekha", ": Sucess"+ApiState.Success(it))

            }
        }
    }

}