package com.example.notekeeper.dataManagers

import com.example.notekeeper.models.CourseInfo
import com.example.notekeeper.models.NoteInfo

object DataManager {
    val courses = HashMap<String, CourseInfo>()
    val notes = ArrayList<NoteInfo>()

    init {
        initializeCourses()
        initializeNotes()
    }

    fun loadNotes(vararg noteIds: Int): List<NoteInfo> {
        simulateLoadDelay()
        val noteList: List<NoteInfo>

        if(noteIds.isEmpty())
            noteList = notes
        else {
            noteList = ArrayList<NoteInfo>(noteIds.size)
            for(noteId in noteIds)
                noteList.add(notes[noteId])
        }
        return noteList
    }

    fun loadNote(noteId: Int) = notes[noteId]

    fun isLastNoteId(noteId: Int) = noteId == notes.lastIndex

    fun idOfNote(note: NoteInfo) = notes.indexOf(note)

    fun noteIdsAsIntArray(notes: List<NoteInfo>): IntArray {
        val noteIds = IntArray(notes.size)
        for(index in 0..notes.lastIndex)
            noteIds[index] = DataManager.idOfNote(notes[index])
        return noteIds
    }

    fun addNote(course: CourseInfo, noteTitle: String, noteText: String): Int {
        return addNote(NoteInfo(course, noteTitle, noteText))
    }

    fun addNote(note: NoteInfo): Int{
        notes.add(note)
        return notes.lastIndex
    }

    fun findNote(course: CourseInfo, noteTitle: String, noteText: String) : NoteInfo? {
        for(note in notes)
            if (course == note.course &&
                noteTitle == note.title &&
                noteText == note.text)
                return note

        return null
    }

    private fun simulateLoadDelay() {
        Thread.sleep(1000)
    }

    private fun initializeCourses() {
        var course = CourseInfo("android_intents", "Android Programming with Intents")
        courses.set(course.courseId, course)

        course = CourseInfo(courseId = "android_async", title = "Android Async Programming and Services")
        courses.set(course.courseId, course)

        course = CourseInfo(title = "Java Fundamentals: The Java Language", courseId = "java_lang")
        courses.set(course.courseId, course)

        course = CourseInfo("java_core", "Java Fundamentals: The Core Platform")
        courses.set(course.courseId, course)
    }

    private fun initializeNotes() {
        var note = NoteInfo(
            CourseInfo("android_intents", "Android Programming with Intents"),
            "Android Intents",
            "This is an Introductory course to Android Intents"
        )
        notes.add(note)

        note = NoteInfo(
            CourseInfo(courseId = "android_async", title = "Android Async Programming and Services"),
            "Android Services",
            "This is an Introductory course to Android services and Ansync operations"
        )
        notes.add(note)

        note = NoteInfo(
            CourseInfo(title = "Java Fundamentals: The Java Language", courseId = "java_lang"),
            "The Java Language",
            "This is an Introductory course to the Java Programming Language"
        )
        notes.add(note)

        note = NoteInfo(
            CourseInfo("java_core", "Java Fundamentals: The Core Platform"),
            "Core Platforms",
            "This is an Introductory course to the Core Platforms"
        )
        notes.add(note)
    }
}