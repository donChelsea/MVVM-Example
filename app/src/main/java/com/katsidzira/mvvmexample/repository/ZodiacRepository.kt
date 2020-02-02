package com.katsidzira.mvvmexample.repository

import android.arch.lifecycle.MutableLiveData
import android.content.ContentValues.TAG
import android.util.Log
import com.katsidzira.mvvmexample.model.Zodiac
import com.katsidzira.mvvmexample.model.ZodiacList
import com.katsidzira.mvvmexample.network.RetrofitSingleton
import com.katsidzira.mvvmexample.network.ZodiacService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ZodiacRepository {

    private val instance = ZodiacRepository()
    private var dataSet: List<Zodiac>? = null

    fun getInstance(): ZodiacRepository {
        return instance
    }

    // get data from a web service or online data source
    fun getZodiacsFromRepo(): MutableLiveData<List<Zodiac>> {
        setZodiacs()
        var data =  MutableLiveData<List<Zodiac>>()
        data.value = dataSet
        return data
    }

    fun setZodiacs() {
        val retrofit = RetrofitSingleton().getInstance()
        var zodiacService: ZodiacService = retrofit!!.create(ZodiacService::class.java)
        zodiacService.getAll().enqueue(object : Callback<ZodiacList> {
            override fun onFailure(call: Call<ZodiacList>, t: Throwable) {
                Log.d(TAG, "on failure: ${t.message}")
            }

            override fun onResponse(call: Call<ZodiacList>, response: Response<ZodiacList>) {
                dataSet = response.body()!!.zodiacList
            }

        })
    }


}