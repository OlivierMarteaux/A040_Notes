package com.openclassrooms.notes.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.openclassrooms.notes.model.Note
import com.openclassrooms.notes.repository.NotesRepository
import kotlinx.coroutines.launch

class NotesViewModel : ViewModel() {

    private val notesRepository = NotesRepository()
    private lateinit var notes: List<Note>

    fun getNotes(): List<Note> {
        viewModelScope.launch {
            notesRepository.notes.collect { notes = it }
        }
        return notes
    }
}