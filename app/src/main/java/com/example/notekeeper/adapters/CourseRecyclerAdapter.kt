package com.example.notekeeper.adapters

import android.content.Context
import android.content.Intent
import android.support.design.widget.Snackbar
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.notekeeper.R
import com.example.notekeeper.activities.NoteActivity
import com.example.notekeeper.constants.EXTRA_NOTE_POSITION
import com.example.notekeeper.models.CourseInfo
import com.example.notekeeper.models.NoteInfo

class CourseRecyclerAdapter(private val context: Context, private val courses: List<CourseInfo>) :
    RecyclerView.Adapter<CourseRecyclerAdapter.ViewHolder>() {

    private val layoutInflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = layoutInflater.inflate(R.layout.list_course_item, parent, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount() = courses.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val course = courses[position]
        holder.course?.text = course.title

        holder.coursePosition = position
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val course = itemView?.findViewById<TextView?>(R.id.course)
        var coursePosition = 0

        init {
            itemView?.setOnClickListener{
                Snackbar.make(it, courses[coursePosition]?.title, Snackbar.LENGTH_LONG).show()
            }
        }

    }
}