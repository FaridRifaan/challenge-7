package com.binar.challenge6.model

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class ResultTest {

    @Test
    fun `result object should have correct values`() {
        // Given
        val result = Result(
            adult = false,
            backdropPath = "/backdrop.jpg",
            genreIds = listOf(1, 2, 3),
            id = 123,
            originalLanguage = "en",
            originalTitle = "Original Title",
            overview = "Overview",
            popularity = 7.8,
            posterPath = "/poster.jpg",
            releaseDate = "2022-01-01",
            title = "Title",
            video = false,
            voteAverage = 6.5,
            voteCount = 100
        )

        // Then
        assertEquals(false, result.adult)
        assertEquals("/backdrop.jpg", result.backdropPath)
        assertEquals(listOf(1, 2, 3), result.genreIds)
        assertEquals(123, result.id)
        assertEquals("en", result.originalLanguage)
        assertEquals("Original Title", result.originalTitle)
        assertEquals("Overview", result.overview)
        assertEquals(7.8, result.popularity, 0.0)
        assertEquals("/poster.jpg", result.posterPath)
        assertEquals("2022-01-01", result.releaseDate)
        assertEquals("Title", result.title)
        assertEquals(false, result.video)
        assertEquals(6.5, result.voteAverage, 0.0)
        assertEquals(100, result.voteCount)
    }

    @Test
    fun testResultGenreIdsNotEmpty() {
        // Membuat objek Result dengan nilai properti yang diharapkan
        val result = Result(
            adult = false,
            backdropPath = "/path/to/backdrop.jpg",
            genreIds = listOf(1, 2, 3),
            id = 123,
            originalLanguage = "en",
            originalTitle = "Original Title",
            overview = "Movie overview",
            popularity = 7.8,
            posterPath = "/path/to/poster.jpg",
            releaseDate = "2022-01-01",
            title = "Movie Title",
            video = false,
            voteAverage = 8.5,
            voteCount = 1000
        )

        // Memeriksa apakah nilai genreIds tidak kosong dengan menggunakan assertTrue
        assertTrue(result.genreIds.isNotEmpty())
    }

}
/*  1.Mengatur Objek Result: Pada bagian komentar  Given, objek Result dibuat dengan nilai-nilai yang ditentukan.
      Objek ini merepresentasikan hasil yang diharapkan.
      Pernyataan Asertion: Pada bagian komentar Then,
      dilakukan beberapa pernyataan asertion untuk memverifikasi bahwa nilai-nilai dalam objek result sesuai
      dengan nilai-nilai yang diharapkan.


    2. testResultGenreIdsNotEmpty(): Pengujian ini memeriksa apakah properti genreIds dalam objek Result tidak kosong
    (notEmpty). Menggunakan assertTrue untuk memastikan bahwa genreIds memiliki elemen di dalamnya

 */