package com.example.tutorial

import androidx.lifecycle.LiveData

class TasksRepository(private val taskDao: TaskDao) {

    val allTasks: LiveData<List<Tasks>> = taskDao.getAllTasks()

    suspend fun insert(tasks: Tasks) {
        taskDao.insert(tasks)
    }

    suspend fun delete(tasks: Tasks) {
        taskDao.delete(tasks)
    }
}