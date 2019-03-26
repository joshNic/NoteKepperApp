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