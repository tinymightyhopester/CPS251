package com.example.lifecycleawarev2.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private var eventText = ""
    private var result: MutableLiveData<String> = MutableLiveData()

    fun setData(value: String){
        this.eventText = this.eventText+"\n"+value
        result.value = eventText
    }

    fun getResult(): MutableLiveData<String> {
        return result
    }

}