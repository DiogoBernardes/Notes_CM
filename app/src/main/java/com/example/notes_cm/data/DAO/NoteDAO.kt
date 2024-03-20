package com.example.notes_cm.data.DAO

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.notes_cm.data.Entities.Note

@Dao
interface NoteDAO {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addNote(note : Note)

    @Update
    suspend fun updateNote(note : Note)

    @Query("SELECT * FROM notes ORDER BY id DESC")
    fun readAllNotes() : LiveData<List<Note>>

    @Delete
    suspend fun deleteNote(note : Note)

}