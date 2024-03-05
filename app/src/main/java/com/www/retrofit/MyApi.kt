package com.www.retrofit

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface MyApi {
    @GET("posts/1/comments")
    fun getComments():Call<List<Post>>
}