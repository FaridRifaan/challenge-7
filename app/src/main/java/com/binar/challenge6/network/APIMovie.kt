package com.binar.challenge6.network

import android.content.Context
import androidx.room.Room
import com.binar.challenge6.database.FavoriteMovieDao
import com.binar.challenge6.database.MovieDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object APIMovie {
    @Singleton
    @Provides
    fun getMovieService(): APIMovieInterface {
        val loggingInterceptor = HttpLoggingInterceptor()
            .setLevel(HttpLoggingInterceptor.Level.BODY)
        val client = OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/3/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
        return retrofit.create(APIMovieInterface::class.java)
    }

    @Provides
    fun provideFavoriteDAO(db : MovieDatabase) : FavoriteMovieDao = db.favoriteDao()

    @Singleton
    @Provides
    fun provideDB(@ApplicationContext context: Context) : MovieDatabase {
        return Room.databaseBuilder(context, MovieDatabase::class.java, "favorite.db")
            .fallbackToDestructiveMigration()
            .build()
    }

}



//    const val BASE_URL = "https://api.themoviedb.org"
//
//    val instance: APIMovieInterface by lazy {
//        val retrofit = Retrofit.Builder()
//            .baseUrl(BASE_URL)
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//        retrofit.create(APIMovieInterface::class.java)
//    }
