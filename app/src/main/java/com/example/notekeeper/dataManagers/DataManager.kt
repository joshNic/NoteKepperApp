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

    private fun initializeCourses(){
        var course = CourseInfo("android_intents", "Android Programming with Intents")
        courses.set(course.courseId, course)

        course = CourseInfo(courseId = "android_async", title = "Android Async Programming and Services")
        courses.set(course.courseId, course)

        course = CourseInfo(title = "Java Fundamentals: The Java Language", courseId = "java_lang")
        courses.set(course.courseId, course)

        course = CourseInfo("java_core", "Java Fundamentals: The Core Platform")
        courses.set(course.courseId, course)
    }
    private fun initializeNotes(){
        var note = NoteInfo(CourseInfo("android_intents", "Java Fundamentals: The Java Language"), "test title", "Another Description")
        notes.add(note)
    }
}