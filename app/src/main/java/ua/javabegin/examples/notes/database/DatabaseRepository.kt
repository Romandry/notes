package ua.javabegin.examples.notes.database

import androidx.lifecycle.LiveData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import ua.javabegin.examples.notes.models.AppNote

interface DatabaseRepository {

    val allNotes: LiveData<List<AppNote>>

    suspend fun insert(note: AppNote, onSuccess:()->Unit)
    suspend fun delete(note: AppNote, onSuccess:()->Unit)
}