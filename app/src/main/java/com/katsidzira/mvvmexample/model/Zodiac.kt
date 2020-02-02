package com.katsidzira.mvvmexample.model

data class Zodiac(
    val name: String,
    val number: String,
    val image: String
)

data class ZodiacList(val zodiacList: List<Zodiac>)