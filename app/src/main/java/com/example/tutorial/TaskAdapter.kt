package com.example.tutorial

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_task.view.*
import kotlin.collections.ArrayList

class TaskAdapter(
        private val context: Context,
        private val listener: TaskClickListener
) : RecyclerView.Adapter<TaskAdapter.TaskViewHolder>() {

    private val taskList = ArrayList<Tasks>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val viewHolder = TaskViewHolder(LayoutInflater.from(context)
                .inflate(R.layout.item_task, parent, false))

        viewHolder.taskDelete.setOnClickListener {
            val position = viewHolder.adapterPosition
            listener.onItemClicked(taskList[position])
        }
        return viewHolder
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        holder.taskTitle.text = taskList[position].text
    }

    override fun getItemCount(): Int {
        return taskList.size
    }

    inner class TaskViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var taskTitle: TextView = itemView.findViewById<TextView>(R.id.tvTitle)
        val taskDelete: ImageView = itemView.findViewById<ImageView>(R.id.ivDelete)
    }

    fun updateList(newList: List<Tasks>) {
        taskList.clear()
        taskList.addAll(newList)
        notifyDataSetChanged()
    }
}

interface TaskClickListener {
    fun onItemClicked(tasks: Tasks)
}