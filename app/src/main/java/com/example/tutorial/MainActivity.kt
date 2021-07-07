package com.example.tutorial

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_task.*

class MainActivity : AppCompatActivity(), TaskClickListener {

    lateinit var viewModel: TaskViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvTasks.layoutManager = LinearLayoutManager(this)
        val adapter = TaskAdapter(this, this)
        rvTasks.adapter = adapter

        viewModel = ViewModelProvider(
            this,
            ViewModelProvider.AndroidViewModelFactory.getInstance(application)
        ).get(TaskViewModel::class.java)

        viewModel.allTasks.observe(this, Observer { list ->
            list?.let {
                adapter.updateList(it)
            }
        })
    }

    override fun onItemClicked(tasks: Tasks) {
        viewModel.deleteTask(tasks)
    }

    fun addTask(view: View) {
        val text = etInput.text.toString()
        text.trim()
        if (text.isNotEmpty()) {
            val newTask = Tasks(text)
            viewModel.addTask(newTask)
            etInput.text.clear()
        }
    }
}
