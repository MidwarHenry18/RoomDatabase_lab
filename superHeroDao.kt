package com.example.practicalab7

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface superHeroDao {
    @Query("SELECT * FROM SuperHerores")
    suspend fun getSuperHero():List<SuperHero>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertHero(hero:SuperHero)

    @Query("DELETE FROM SuperHerores")
    suspend fun deleteALl()

    @Query("SELECT * FROM SuperHerores WHERE title like :title")
    suspend fun  getByTitle(title: String):List<SuperHero>
}