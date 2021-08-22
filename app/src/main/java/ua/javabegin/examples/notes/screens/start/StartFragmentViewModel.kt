package ua.javabegin.examples.notes.screens.start

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import ua.javabegin.examples.notes.database.room.AppRoomDatabase
import ua.javabegin.examples.notes.database.room.AppRoomRepository
import ua.javabegin.examples.notes.utilites.REPOSITORY
import ua.javabegin.examples.notes.utilites.TYPE_FIREBASE
import ua.javabegin.examples.notes.utilites.TYPE_ROOM
import ua.javabegin.examples.notes.utilites.showToast

class StartFragmentViewModel(application: Application): AndroidViewModel(application) {

    private val mContext = application

    fun initDatabase(type: String, onSuccess:()->Unit) {
        when(type) {
            TYPE_ROOM -> {
                val dao = AppRoomDatabase.getInstance(mContext).getAppRoomDao()
                REPOSITORY = AppRoomRepository(dao)
                onSuccess()
            }

            TYPE_FIREBASE -> {
                showToast(TYPE_FIREBASE)
            }
        }
    }
}