package com.example.lifecycleawarev2.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    companion object{
        private var result: MutableLiveData<String> = MutableLiveData()
        private var msg = ""
        fun addResult(status: String) {
            msg += status
            result.value = msg
        }
    }

    fun getStatus(): MutableLiveData<String>{
        return result
    }

}