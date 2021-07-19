package com.example.tutorial

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        mainViewModel.value.observe(this, {
            tvValue.text = it
        })

        btnUpdate.setOnClickListener {
            mainViewModel.updateLiveData()
        }

        btnReset.setOnClickListener {
            mainViewModel.resetLiveData()
        }
    }
}
