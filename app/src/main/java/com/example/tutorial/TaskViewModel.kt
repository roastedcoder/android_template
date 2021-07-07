package com.example.tutorial

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TaskViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: TasksRepository
    val allTasks: LiveData<List<Tasks>>

    init {
        val dao = TaskDB.getDatabase(application).getTasksDao()
        repository = TasksRepository(dao)
        allTasks = repository.allTasks
    }

    fun deleteTask(tasks: Tasks) = viewModelScope.launch(Dispatchers.IO) {
        repository.delete(tasks)
    }

    fun addTask(tasks: Tasks) = viewModelScope.launch(Dispatchers.IO) {
        repository.insert(tasks)
    }
}