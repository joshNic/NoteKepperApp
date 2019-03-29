package com.example.notekeeper.adapters

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.notekeeper.R
import com.example.notekeeper.activities.NoteActivity
import com.example.notekeeper.constants.EXTRA_NOTE_POSITION
import com.example.notekeeper.models.NoteInfo

class NoteRecyclerAdapter(private val context: Context, private val notes: List<NoteInfo>) :
    RecyclerView.Adapter<NoteRecyclerAdapter.ViewHolder>() {

    private val layoutInflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = layoutInflater.inflate(R.layout.list_note_item, parent, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount() = notes.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val note = notes[position]
        holder.textCourse?.text = note.course?.title
        holder.textTitle?.text = note.title
        holder.notePosition = position
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textCourse = itemView?.findViewById<TextView?>(R.id.textCourse)
        val textTitle = itemView?.findViewById<TextView?>(R.id.textTitle)
        var notePosition = 0

        init {
            itemView?.setOnClickListener{
                val intent = Intent(context, NoteActivity::class.java)
                intent.putExtra(EXTRA_NOTE_POSITION, notePosition)
                context.startActivity(intent)
            }
        }

    }
}