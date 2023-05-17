package com.binar.challenge6.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object APIMovie {
    const val BASE_URL = "https://api.themoviedb.org"

    val instance: APIMovieInterface by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        retrofit.create(APIMovieInterface::class.java)
    }
}