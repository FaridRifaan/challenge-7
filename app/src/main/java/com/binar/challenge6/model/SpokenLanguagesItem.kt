@file:Suppress("unused")

package com.binar.challenge6.model

import com.google.gson.annotations.SerializedName

@Suppress("unused", "unused", "unused")
data class SpokenLanguagesItem(

    @field:SerializedName("name")
    val name: String? = null,

    @field:SerializedName("iso_639_1")
    val iso6391: String? = null,

    @field:SerializedName("english_name")
    val englishName: String? = null
)