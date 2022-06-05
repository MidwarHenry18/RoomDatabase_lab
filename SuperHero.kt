package com.example.practicalab7

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "SuperHerores")
data class SuperHero(
    @PrimaryKey (autoGenerate = true)val id: Int,
    @ColumnInfo  (name = "Name") val superhero: String,
    @ColumnInfo(name = "title") val publisher: String,
    @ColumnInfo  (name = "classification") val realName: String,
    @ColumnInfo (name = "ulrImage") val photo: String
)