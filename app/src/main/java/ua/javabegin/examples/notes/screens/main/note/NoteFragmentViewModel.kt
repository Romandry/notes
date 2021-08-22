package ua.javabegin.examples.notes.screens.main.note

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import ua.javabegin.examples.notes.models.AppNote
import ua.javabegin.examples.notes.utilites.REPOSITORY

class NoteFragmentViewModel(application: Application): AndroidViewModel(application) {

    fun delete(note: AppNote, onSuccess:()->Unit) =
            viewModelScope.launch(Dispatchers.Main) {
                REPOSITORY.delete(note) {
                    onSuccess()
                }
            }
}