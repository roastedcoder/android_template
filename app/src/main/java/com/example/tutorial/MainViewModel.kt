package com.example.tutorial

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {
    private val privateValue = MutableLiveData <String> ("Initial Value")

    val value : LiveData <String>
    get() = privateValue

    fun updateLiveData() {
        privateValue.value = "Final Value"
    }

    fun resetLiveData() {
        privateValue.value = "Initial Value"
    }

}