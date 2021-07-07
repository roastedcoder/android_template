package com.example.tutorial

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tasks_table")
class Tasks(@ColumnInfo(name = "text") var text: String) {
    @PrimaryKey(autoGenerate = true) var id = 0
}