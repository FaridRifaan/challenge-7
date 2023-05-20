package com.binar.challenge6.database

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize


@Entity
data class FavoriteMovie (
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    @ColumnInfo(name = "title")
    var title : String,
    @ColumnInfo(name = "release")
    var releasedate: String,
    @ColumnInfo(name = "posterpath")
    var posterPath : String

): java.io.Serializable
