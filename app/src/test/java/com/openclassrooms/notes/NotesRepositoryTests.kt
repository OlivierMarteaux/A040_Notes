package com.openclassrooms.notes

import com.openclassrooms.notes.repository.NotesRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class NotesRepositoryTest {

    @Test
    fun notesFlow_emitsPredefinedNotes() = runTest {
        // Given
        val notesRepository = NotesRepository()

        // When
        val result = notesRepository.notes.first()

        // Then
        assertEquals(10, result.size)
        assertEquals("La vie est belle", result[0].title)
        assertEquals("Risez et amusez-vous.", result[9].title)
    }
}