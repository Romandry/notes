package ua.javabegin.examples.notes.screens.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import ua.javabegin.examples.notes.utilites.REPOSITORY

class MainFragmentViewModel(application: Application): AndroidViewModel(application) {

    val allNotes = REPOSITORY.allNotes
}