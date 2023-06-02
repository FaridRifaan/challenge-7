package com.binar.challenge6.network

import com.binar.challenge6.database.FavoriteMovieDao
import com.binar.challenge6.database.MovieDatabase
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class APIMovieTest {

    @Mock
    private lateinit var mockedMovieDatabase: MovieDatabase

    @Mock
    private lateinit var mockedFavoriteMovieDao: FavoriteMovieDao

    private lateinit var apiMovie: APIMovie

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        apiMovie = APIMovie
    }

    @Test
    fun getMovieService() {
        val movieService = apiMovie.getMovieService()

        assertNotNull(movieService)
    }

    @Test
    fun provideFavoriteDAO() {
        `when`(mockedMovieDatabase.favoriteDao()).thenReturn(mockedFavoriteMovieDao)

        val favoriteDao = apiMovie.provideFavoriteDAO(mockedMovieDatabase)

        assertNotNull(favoriteDao)
    }


}

// 1. Pengujian getMovieService(): Pengujian ini bertujuan untuk memastikan bahwa objek apiMovie dapat
//    mengembalikan layanan (service) film dengan benar.
//    Metode ini menggunakan Mockito untuk menginisialisasi objek apiMovie dan memanggil metode getMovieService().
//    Kemudian, pengujian memeriksa apakah objek movieService yang dikembalikan tidak null (assertNotNull(movieService)).


// 2. Pengujian provideFavoriteDAO(): Pengujian ini bertujuan untuk memastikan bahwa metode provideFavoriteDAO()
// pada objek apiMovie berfungsi dengan benar. Metode ini menggunakan Mockito untuk menyusun skenario yang berbeda.
// Dalam pengujian ini, menggunakan pernyataan when untuk menyatakan bahwa ketika mockedMovieDatabase.favoriteDao() dipanggil,
// akan mengembalikan objek mockedFavoriteMovieDao. Kemudian, pengujian memanggil metode provideFavoriteDAO() dengan menyediakan
// objek mockedMovieDatabase. Terakhir, pengujian memeriksa apakah objek favoriteDao
// yang dikembalikan tidak null (assertNotNull(favoriteDao)).