package com.example.practicalab7

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import kotlin.synchronized as synchronized1

@Database(entities = arrayOf(SuperHero::class), version = 1, exportSchema = false)
abstract class AppRoomDatabase: RoomDatabase() {

    abstract fun superheroresDao():superHeroDao

    companion object{
        @Volatile
        private var INSTANCE : AppRoomDatabase? = null

        fun getDatabase(context: Context):AppRoomDatabase{
            return  INSTANCE?: synchronized1(this){
                val  instance = Room.databaseBuilder(
                    context,
                    AppRoomDatabase::class.java,
                    "superHero.db"
                ).build()
                INSTANCE = instance
                return instance
            }

        }
    }
}