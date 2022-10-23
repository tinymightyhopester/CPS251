package com.ebookfrenzy.viewmodeldemo.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.MutableLiveData

class MainViewModel : ViewModel() {

    private var nameText = ""
    private var result: MutableLiveData<String> = MutableLiveData()

    fun setName(value: String) {
        this.nameText = this.nameText+"\n"+value
        result.value = this.nameText
    }

    fun getResult(): MutableLiveData<String> {
        return result
    }
}