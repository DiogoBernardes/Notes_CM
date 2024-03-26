package com.example.notes_cm.data.vm

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.notes_cm.data.entities.Note
import com.example.notes_cm.data.repository.NoteRepository
import com.example.notes_cm.data.db.NoteDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

// ViewModel que os fornece dados para a interface do utilizador
class NoteViewModel(application: Application) : AndroidViewModel(application) {

    val readAllNotes: LiveData<List<Note>>
    private val repository: NoteRepository // Repositório para interagir com a BD

    init {
        // Inicialização do ViewModel
        val noteDao = NoteDatabase.getDatabase(application).noteDao()
        repository = NoteRepository(noteDao)
        readAllNotes = repository.readAllNotes
    }


    /** Estes métodos iniciam uma nova coroutine no viewModelScope usando o contexto Dispatchers.IO,
    que é otimizado para operações de entrada e saída, como acesso a BD.**/
    /**coroutine é uma estrutura de programação concorrente e assíncrona que permite
    que partes do código sejam executadas de forma independente, sem bloquear a thread principal.**/
    fun addNote(note: Note) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addNote(note)
        }
    }
    fun updateNote(note: Note) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateNote(note)
        }
    }

    fun deleteNote(note: Note) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteNote(note)
        }
    }
}