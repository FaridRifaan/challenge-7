package com.binar.challenge6.network

import com.binar.challenge6.model.DetailMovieItem
import com.binar.challenge6.model.MoviePopular
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface APIMovieInterface {
    @GET("movie/popular?api_key=7d8d14c59d48644acd9d52f2409a2dab&language=en-US&page=1")
    fun getPopularMovie(): Call<MoviePopular>

    @GET("movie/{id}?api_key=7d8d14c59d48644acd9d52f2409a2dab")
    fun getMovieDetail(@Path("id") id : Int): Call<DetailMovieItem>

}