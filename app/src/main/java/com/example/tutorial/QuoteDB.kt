package com.example.tutorial

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Quote::class], version = 1)
abstract class QuoteDB: RoomDatabase() {

    abstract fun quoteDao(): QuoteDao

    companion object {
        private var INSTANCE: QuoteDB? = null
        fun getDatabase(context: Context): QuoteDB {
            if(INSTANCE == null) {
                synchronized(this) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        QuoteDB::class.java,
                        "quote_database")
                        .createFromAsset("quotes.db")
                        .build()
                }
            }
            return INSTANCE!!
        }
    }
}