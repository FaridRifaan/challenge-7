@file:Suppress("unused", "unused", "unused", "unused", "unused", "unused", "unused", "unused",
    "unused", "unused", "unused", "unused", "unused", "unused", "unused", "unused"
)

package com.binar.challenge6.model


import com.google.gson.annotations.SerializedName

@Suppress("unused", "unused", "unused", "unused", "unused", "unused", "unused", "unused", "unused",
    "unused", "unused"
)
data class MoviePopular(
    @SerializedName("page")
    val page: Int,
    @SerializedName("results")
    val results: List<Result>,
    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("total_results")
    val totalResults: Int
)