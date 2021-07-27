package com.example.tutorial

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "contact")
class Contact(var name: String, var phone: String) {
    @PrimaryKey(autoGenerate = true) var id = 0
}
