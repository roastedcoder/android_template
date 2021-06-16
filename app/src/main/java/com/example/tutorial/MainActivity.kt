package com.example.tutorial

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // we should use shared preferences to save small data such as setting preferences, game high-score etc.
        // for larger data(to do app) we need a database
        val sharedPref = getSharedPreferences("myPref", Context.MODE_PRIVATE)

        // whenever we want to write to shared preferences we need an editor
        val editor = sharedPref.edit()

        btnSave.setOnClickListener {
            val name = etName.text.toString()
            val age = etAge.text.toString().toInt()
            val isAdult = cbAdult.isChecked

            editor.apply {
                // it takes a key- value pair to fetch the data later
                putString("name", name)
                putInt("age", age)
                putBoolean("isAdult", isAdult)
                apply()
                // we can also use commit here instead of apply
                // but since it puts the data synchronously in shared preferences
                // and blocks the main thread and UI
                // hence we prefer to use apply here
            }
        }

        btnLoad.setOnClickListener {
            val name = sharedPref.getString("name", null)
            val age = sharedPref.getInt("age", 0)
            val isAdult = sharedPref.getBoolean("isAdult", false)

            etName.setText(name.toString())
            etAge.setText(age.toString())
            cbAdult.isChecked = isAdult
        }
    }
}
