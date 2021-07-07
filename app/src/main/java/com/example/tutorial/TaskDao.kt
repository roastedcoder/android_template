package com.example.tutorial

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface TaskDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(tasks: Tasks)

    @Delete
    suspend fun delete(tasks: Tasks)

    @Query("SELECT * FROM tasks_table ORDER BY id ASC")
    fun getAllTasks(): LiveData<List <Tasks>>
}