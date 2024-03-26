package com.example.notes_cm.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.notes_cm.data.dao.NoteDAO
import com.example.notes_cm.data.entities.Note

//Indica que esta classe representa uma base de dados Room
@Database(entities = [Note :: class], version = 1, exportSchema = false)
abstract class NoteDatabase : RoomDatabase() {
    //Obtemos o DAO associado à BD
    abstract fun noteDao() : NoteDAO

    // Companion Object fornece métodos de criação de objetos da BD
    companion object {
        // Variável volátil que garante que o objeto é sempre lido e gravado na memória
        @Volatile
        private var INSTANCE: NoteDatabase? = null

        // Método para obter uma instância da BD
        fun getDatabase(context: Context): NoteDatabase {
            // Verifica se já existe uma instância
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            // Se não existir, sincroniza o acesso para evitar criação duplicada
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    NoteDatabase::class.java,
                    "note_database"
                ).build()
                // Atribui a nova instância à variável INSTANCE e retorna
                INSTANCE = instance
                return instance
            }
        }
    }
}