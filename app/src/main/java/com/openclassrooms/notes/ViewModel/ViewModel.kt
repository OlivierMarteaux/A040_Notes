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

class NotesViewModel(notesRepository: NotesRepository) : ViewModel() {

}