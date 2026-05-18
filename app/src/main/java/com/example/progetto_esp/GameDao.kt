package com.example.progetto_esp

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface GameDao {
    @Query("SELECT * FROM games_table ORDER BY id DESC")
    fun getAllGames(): LiveData<List<Sequence>>

    @Insert
    suspend fun insertGame(sequence: Sequence)

    @Query("SELECT * FROM games_table WHERE id = :id")
    fun getGameById(id: Int): LiveData<Sequence>
}