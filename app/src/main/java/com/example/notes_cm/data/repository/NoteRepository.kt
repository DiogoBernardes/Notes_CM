package com.example.notes_cm.data.repository

import androidx.lifecycle.LiveData
import com.example.notes_cm.data.dao.NoteDAO
import com.example.notes_cm.data.entities.Note

class NoteRepository(private val noteDao : NoteDAO) {
    val readAllNotes: LiveData<List<Note>> = noteDao.readAllNotes()

    suspend fun addNote(note: Note){
        noteDao.addNote(note)
    }

    suspend fun updateNote(note: Note){
        noteDao.updateNote(note)
    }
    suspend fun deleteNote(note: Note){
        noteDao.deleteNote(note)
    }

}