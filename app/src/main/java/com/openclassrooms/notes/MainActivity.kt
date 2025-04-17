package com.openclassrooms.notes

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.openclassrooms.notes.ViewModel.NotesViewModel
import com.openclassrooms.notes.databinding.ActivityMainBinding
import com.openclassrooms.notes.widget.NoteItemDecoration
import com.openclassrooms.notes.widget.NotesAdapter
import kotlinx.coroutines.launch

/**
 * The main activity for the app.
 */
class MainActivity : AppCompatActivity() {

    /**
     * The binding for the main layout.
     */
    private lateinit var binding: ActivityMainBinding

    /**
     * An adapter for displaying a list of notes in a RecyclerView.
     */
    private val notesAdapter = NotesAdapter(emptyList())

//    private val notesRepository = NotesRepository()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        /** Create a ViewModel the first time the system calls an activity's onCreate() method.
         *  Re-created activities receive the same ViewModel instance created by the first activity.
         *  Use the 'by viewModels()' Kotlin property delegate from the activity-ktx artifact
         */
        val notesViewModel: NotesViewModel by viewModels()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initRecyclerView()
        initFABButton()
        collectNotes(notesViewModel)
    }

//    /**
//     * Collects notes from the repository and updates the adapter.
//     */
//    private fun collectNotes() {
//        lifecycleScope.launch {
//            notesRepository.notes.collect {
//                notesAdapter.updateNotes(it)
//            }
//        }
//    }

    /**
     * Collects notes from the viewModel and updates the adapter.
     */
    private fun collectNotes(notesViewModel: NotesViewModel) {
        lifecycleScope.launch {
            notesViewModel.notes.collect {
                notesAdapter.updateNotes(it)
            }
        }
    }

    /**
     * Initializes the FAB button.
     */
    private fun initFABButton() {
        binding.btnAdd.setOnClickListener {
            MaterialAlertDialogBuilder(this).apply {
                setTitle(R.string.coming_soon)
                setMessage(R.string.not_available_yet)
                setPositiveButton(android.R.string.ok, null)
            }.show()
        }
    }

    /**
     * Initializes the RecyclerView.
     */
    private fun initRecyclerView() {
        with(binding.recycler) {
            addItemDecoration(
                NoteItemDecoration(
                    resources.getDimensionPixelSize(R.dimen.default_margin),
                    resources.getInteger(R.integer.span_count)
                )
            )
            adapter = notesAdapter
        }
    }
}
