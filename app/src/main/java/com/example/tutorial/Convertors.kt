package com.example.tutorial

import androidx.room.TypeConverter
import java.util.*

class Convertors {

    @TypeConverter
    fun dateToLong(value: Date) : Long {
        return value.time
    }

    @TypeConverter
    fun longToDate(value: Long): Date {
        return Date(value)
    }
}