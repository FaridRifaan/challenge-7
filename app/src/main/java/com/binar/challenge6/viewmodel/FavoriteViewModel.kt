@file:Suppress("unused", "unused", "unused", "PrivatePropertyName", "PrivatePropertyName")

package com.binar.challenge6.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.binar.challenge6.database.FavoriteMovie
import com.binar.challenge6.database.FavoriteMovieDao
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject

@Suppress("unused", "unused", "unused", "PrivatePropertyName", "PrivatePropertyName")
@HiltViewModel
class FavoriteViewModel @Inject constructor(private val db : FavoriteMovieDao): ViewModel(){

    private val _movie: MutableLiveData<FavoriteMovie> = MutableLiveData()
    val movie: LiveData<FavoriteMovie> get() = _movie

    private val _ListMovie: MutableLiveData<List<FavoriteMovie>> = MutableLiveData()
    val listMovie: LiveData<List<FavoriteMovie>> get() = _ListMovie


    fun getAllFavoriteMovie() {
        GlobalScope.launch {
            _ListMovie.postValue(db.getAllFavorite())
        }
    }

    fun deleteFavMovie(favMovie: FavoriteMovie) {
        GlobalScope.launch {
            db.deleteFavorite(favMovie)
            _movie.postValue(favMovie)
        }
    }

}