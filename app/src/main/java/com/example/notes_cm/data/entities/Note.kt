package com.example.notes_cm.data.entities

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize //Habilita a implementação automática de Parcelable
@Entity(tableName = "notes")//Define a classe como uma entidade na base de dados
class Note(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "note") val note: String
) : Parcelable //Permite que os objetos desta classe sejam serializadas para que possam ser passados entre componentes