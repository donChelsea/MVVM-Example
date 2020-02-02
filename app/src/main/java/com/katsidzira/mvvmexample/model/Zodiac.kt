package com.katsidzira.mvvmexample.model

import com.google.gson.annotations.SerializedName

data class Zodiac(
    val name: String,
    val number: String,
    val image: String
)

data class ZodiacList(@SerializedName("zodiac") val zodiacList: List<Zodiac>)