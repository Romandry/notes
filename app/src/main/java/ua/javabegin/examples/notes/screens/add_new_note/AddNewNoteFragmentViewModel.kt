package ua.javabegin.examples.notes.screens.add_new_note

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import ua.javabegin.examples.notes.models.AppNote
import ua.javabegin.examples.notes.utilites.REPOSITORY

class AddNewNoteFragmentViewModel(application: Application): AndroidViewModel(application) {

    fun insert(note:AppNote, onSuccess:()->Unit) =
        viewModelScope.launch(Dispatchers.Main) {
            REPOSITORY.insert(note) {
                onSuccess()
            }
        }
}