@file:Suppress("SpellCheckingInspection", "SpellCheckingInspection", "SpellCheckingInspection",
    "SpellCheckingInspection", "unused", "unused", "unused"
)

package com.binar.challenge6.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Suppress("SpellCheckingInspection", "SpellCheckingInspection", "unused", "unused", "unused",
    "unused", "unused", "unused", "unused", "unused", "unused", "unused", "unused", "unused",
    "unused", "unused", "unused", "unused", "unused", "unused", "unused", "unused", "unused",
    "unused", "unused", "unused", "unused", "unused", "unused", "unused", "unused", "unused"
)
@Entity
data class FavoriteMovie (
    @Suppress("unused", "unused", "unused", "unused", "unused", "unused", "unused", "unused",
        "unused", "unused", "unused", "unused", "unused", "unused", "unused", "unused", "unused",
        "unused", "unused", "unused", "unused", "unused", "unused", "unused", "unused", "unused",
        "unused", "unused", "unused", "unused"
    ) @PrimaryKey(autoGenerate = true)
    var id: Int,
    @ColumnInfo(name = "title")
    var title : String,
    @ColumnInfo(name = "release")
    var releasedate: String,
    @ColumnInfo(name = "posterpath")
    var posterPath : String

): java.io.Serializable
