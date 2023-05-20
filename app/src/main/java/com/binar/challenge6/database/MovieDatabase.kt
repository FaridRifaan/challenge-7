@file:Suppress("RemoveEmptyPrimaryConstructor")

package com.binar.challenge6.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Suppress("RemoveEmptyPrimaryConstructor")
@Database(entities = [FavoriteMovie::class], version = 1)
abstract class MovieDatabase(): RoomDatabase() {

    abstract fun favoriteDao(): FavoriteMovieDao

}