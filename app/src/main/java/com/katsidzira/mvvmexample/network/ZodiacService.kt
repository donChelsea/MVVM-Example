package com.katsidzira.mvvmexample.network

import com.katsidzira.mvvmexample.model.ZodiacList
import retrofit2.Call
import retrofit2.http.GET

interface ZodiacService {

    @GET("JDVila/storybook/master/zodiac.json")
    fun getAll(): Call<ZodiacList>
}