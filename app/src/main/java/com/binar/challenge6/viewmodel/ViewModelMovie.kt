package com.binar.challenge6.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.binar.challenge6.model.MoviePopular
import com.binar.challenge6.model.Result
import com.binar.challenge6.network.APIMovieInterface
import dagger.hilt.android.lifecycle.HiltViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class ViewModelMovie @Inject constructor(private val movieDataClient : APIMovieInterface):
    ViewModel() {


    private val _movie: MutableLiveData<List<Result>> = MutableLiveData()
    val movie: LiveData<List<Result>> get() = _movie

    fun setMoviesList() {
        movieDataClient.getPopularMovie()
            .enqueue(object : Callback<MoviePopular> {
                override fun onResponse(
                    call: Call<MoviePopular>,
                    response: Response<MoviePopular>
                ) {
                    if (response.isSuccessful) {
                        val data = response.body()
                        if (data != null) {
                            _movie.postValue(data.results as List<Result>?)
                        }
                    }
                }

                override fun onFailure(call: Call<MoviePopular>, t: Throwable) {

                }

            })
    }

}