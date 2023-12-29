package com.example.cleanarchitechturekotlin.Post.presentation

import android.content.Context
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

import com.example.cleanarchitechturekotlin.Post.presentation.component.GETData
import com.example.cleanarchitechturekotlin.ui.theme.CleanArchitechtureKotlinTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PostActivity : ComponentActivity() {


    private val viewModel: PostViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CleanArchitechtureKotlinTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    val mainViewModel = viewModel


                    Column(modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.SpaceEvenly) {
                        Button( modifier = Modifier.fillMaxWidth(),onClick = { mainViewModel.getRequest() }) {
                            Text(text = "Get Data")
                        }
                        Spacer(modifier = Modifier.height(5.dp))
                        GETData(mainViewModel = mainViewModel)
                    }


                }
            }
        }
    }

}