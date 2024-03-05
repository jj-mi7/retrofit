package com.www.retrofit

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.www.retrofit.ui.theme.RetrofitTheme
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class MainActivity : ComponentActivity() {
    private val Tag:String="joel"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Button(onClick = {
                val call = ApiClient.apiService.getComments().enqueue(object :Callback<List<Post>>{
                override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
                    if (response.isSuccessful){

                        response.body()?.let {
                            for(post in it){

                                Log.d(Tag,"${post.body}")
                            }
                        }
                    }
                }

                override fun onFailure(call: Call<List<Post>>, t: Throwable) {
                    TODO("Not yet implemented")
                }

            })}) {
                Text(text = "get")

            }

        }
    }


    }

