package com.example.tutorial

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {

    private val quote = "With great power comes great responsibilities"
    val quoteLiveData = MutableLiveData <String> (quote)

    fun updateQuote() {
        quoteLiveData.value = "When deeds speak, words are nothing"
    }
    fun resetQuote() {
        quoteLiveData.value = quote
    }
}