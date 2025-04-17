package com.openclassrooms.notes.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.openclassrooms.notes.repository.NotesRepository
import com.openclassrooms.notes.widget.NotesAdapter
import kotlinx.coroutines.launch

public class NotesViewModel() : ViewModel() {

    private val notesRepository = NotesRepository()
    private val notesAdapter = NotesAdapter(emptyList())

    /**
     * Collects notes from the repository and updates the adapter.
     */
    public fun collectNotes() {
        viewModelScope.launch {
            notesRepository.notes.collect {
                notesAdapter.updateNotes(it)
            }
        }
    }

}