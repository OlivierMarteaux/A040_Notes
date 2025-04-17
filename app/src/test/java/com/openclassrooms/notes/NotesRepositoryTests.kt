package com.openclassrooms.notes

import com.openclassrooms.notes.repository.NotesRepository
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Test

class NotesRepositoryTest {

    @Test
    fun notesRepository_notesFlowCollected_emitsPredefinedNotes() = runTest {
        // Given: the NotesRepository with predefined notes
        val notesRepository = NotesRepository()

        // When: the notes flow is collected
        val result = notesRepository.notes.first()

        // Then: the flow emits the predefined notes
        assertEquals(10, result.size)
        assertEquals("La vie est belle", result[0].title)
        assertEquals("Riez et amusez-vous.", result[9].title)
    }
}