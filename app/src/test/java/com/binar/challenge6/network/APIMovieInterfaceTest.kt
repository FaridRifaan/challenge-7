package com.binar.challenge6.network

import com.binar.challenge6.model.MoviePopular
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class APIMovieInterfaceTest {
    private lateinit var apiMovieInterface: APIMovieInterface

    @Before
    fun setup() {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/3/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        apiMovieInterface = retrofit.create(APIMovieInterface::class.java)
    }

    @Test
    fun testGetPopularMovie() {
        val call: Call<MoviePopular> = apiMovieInterface.getPopularMovie()
        val response: Response<MoviePopular> = call.execute()

        assertEquals(200, response.code())
        assertEquals(true, response.isSuccessful)
        assertNotNull(response.body())
        }

}

// 1. Pengujian setup(): Metode ini digunakan untuk mengatur konfigurasi Retrofit.
// Retrofit adalah sebuah library HTTP client yang digunakan untuk berkomunikasi dengan API web.
// Pada pengujian ini, menggunakan Retrofit.Builder() untuk membuat objek Retrofit dengan konfigurasi yang sesuai.
// Konfigurasi tersebut termasuk URL dasar ("https://api.themoviedb.org/3/") dan
// konverter Gson untuk mengonversi respons JSON menjadi objek Java. Kemudian, dengan memanggil
// retrofit.create(APIMovieInterface::class.java), objek apiMovieInterface
// dibuat berdasarkan antarmuka APIMovieInterface.


// 2. Pengujian testGetPopularMovie(): Pengujian ini bertujuan untuk memeriksa apakah metode getPopularMovie()
// dalam APIMovieInterface berfungsi dengan benar. Metode ini memanggil metode getPopularMovie() pada apiMovieInterface
// yang mengembalikan objek Call<MoviePopular>. Kemudian, menggunakan call.execute() untuk melakukan panggilan sinkron
// ke API dan mendapatkan respons Response<MoviePopular>. Pada pengujian ini,
// dilakukan beberapa asserstion untuk memverifikasi respons tersebut:
//assertEquals(200, response.code()): Memeriksa apakah kode respons adalah 200 (kode OK),
// menunjukkan bahwa panggilan berhasil.
//assertEquals(true, response.isSuccessful): Memeriksa apakah panggilan berhasil (sukses),
// menunjukkan bahwa respons memiliki kode status yang valid (2xx).
//assertNotNull(response.body()): Memeriksa apakah tubuh (body) respons tidak null,
// menunjukkan bahwa respons mengandung data yang valid.