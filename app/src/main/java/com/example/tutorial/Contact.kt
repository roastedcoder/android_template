package com.example.tutorial

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity (tableName = "contact")
class Contact(
    var name: String,
    var phone: String,
    val createdDate: Date,
    val isActive: Int) {
    @PrimaryKey(autoGenerate = true) var id = 0
}
