package com.katsidzira.mvvmexample.model

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.katsidzira.mvvmexample.repository.ZodiacRepository

class ZodiacViewModel : ViewModel() {

    private var zodiacs = MutableLiveData<List<Zodiac>>()
    private var zodiacRepo = ZodiacRepository()

    fun init()  {
        zodiacRepo = ZodiacRepository().getInstance()
        zodiacs = zodiacRepo.getZodiacsFromRepo()
    }

    fun getZodiacs(): LiveData<List<Zodiac>> {
        return zodiacs
    }


}