package com.example.cleanarchitechturekotlin.Post.presentation.component

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.example.cleanarchitechturekotlin.Post.presentation.PostViewModel
import com.example.cleanarchitechturekotlin.Post.util.ApiState

@Composable
fun PostDataViewComposable() {


}
@Composable
fun GETData(mainViewModel: PostViewModel){
    when(val result = mainViewModel.response.value){
        is ApiState.Success->{
            LazyColumn{
                items(result.data){ response->
                    Text(text =response.body )
//                        EachRow( response)
                }
            }
        }
        is ApiState.Failure->{
            Text(text = "${result.msg}")
        }
        ApiState.Loading->{
            CircularProgressIndicator()
        }
        ApiState.Empty->{

        }
    }
}
