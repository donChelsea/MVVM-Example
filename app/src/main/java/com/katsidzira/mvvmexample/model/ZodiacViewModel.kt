package com.katsidzira.mvvmexample.model

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.katsidzira.mvvmexample.model.Zodiac

class ZodiacViewModel() : ViewModel() {

    private val zodiacs = MutableLiveData<List<Zodiac>>()

    fun getZodiacs(): LiveData<List<Zodiac>> {
        return zodiacs
    }
}