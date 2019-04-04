package com.example.notekeeper.viewModels

import android.arch.lifecycle.ViewModel
import android.os.Bundle
import com.example.notekeeper.R
import com.example.notekeeper.dataManagers.DataManager
import com.example.notekeeper.models.NoteInfo

@Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
class ItemsActivityViewModel: ViewModel() {

    var isNewlyCreated = true
    var navigationDrawerDisplaySelectionName = "com.example.notekeeper.viewModels.navigationDrawerDisplaySelection"
    var recentlyViewedNoteIdsName = "com.example.notekeeper.viewModels.recentlyViewedNoteIds"

    var navigationDrawerDisplaySelection = R.id.nav_notes

    private val maxRecentlyViewedNotes = 5
    val recentlyViewedNotes = ArrayList<NoteInfo>(maxRecentlyViewedNotes)


    fun addToRecentlyViewedNotes(note: NoteInfo) {
        // Check if selection is already in list
        val existingIndex = recentlyViewedNotes.indexOf(note)
        if (existingIndex == -1) {
            recentlyViewedNotes.add(0, note)
            for (index in recentlyViewedNotes.lastIndex downTo maxRecentlyViewedNotes)
                recentlyViewedNotes.removeAt(index)
        } else {
            for (index in (existingIndex - 1) downTo 0)
                recentlyViewedNotes[index + 1] = recentlyViewedNotes[index]
            recentlyViewedNotes[0] = note
        }

    }

    fun saveState(outState: Bundle) {
        outState.putInt(navigationDrawerDisplaySelectionName, navigationDrawerDisplaySelection)
        val noteIds = DataManager.noteIdsAsIntArray(recentlyViewedNotes)
        outState.putIntArray(recentlyViewedNoteIdsName, noteIds)

    }

    fun restoreState(savedInstanceState: Bundle) {
       navigationDrawerDisplaySelection = savedInstanceState.getInt(navigationDrawerDisplaySelectionName)
        val notesIds = savedInstanceState.getIntArray(recentlyViewedNoteIdsName)
        val noteList = DataManager.loadNotes(*notesIds)
        recentlyViewedNotes.addAll(noteList)


    }
}