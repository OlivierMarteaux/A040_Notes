package com.openclassrooms.notes.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.openclassrooms.notes.repository.NotesRepository
import com.openclassrooms.notes.widget.NotesAdapter
import kotlinx.coroutines.launch

class NotesViewModel() : ViewModel() {

    private val notesRepository = NotesRepository()

    val notes = notesRepository.notes

}