package com.example.taskme.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI

import androidx.recyclerview.widget.RecyclerView

import com.example.taskme.database.models.Task
import com.example.taskme.databinding.ListItemTaskBinding
import kotlinx.android.synthetic.main.list_item_task.view.*


class TaskRecyclerAdapter : RecyclerView.Adapter<TaskRecyclerAdapter.TaskViewHolder>() {

    private var taskList = emptyList<Task>()

    class TaskViewHolder(val binding: ListItemTaskBinding) : RecyclerView.ViewHolder(binding.root) {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {

        val inflater = parent.context.getSystemService(LayoutInflater::class.java)
        val binding = ListItemTaskBinding.inflate(inflater, parent, false)

        return TaskViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        val currentTask = taskList[position]


        holder.binding.tvTitle.text = currentTask.title
        holder.binding.tvTask.text = currentTask.task

        holder.itemView.taskItem.setOnClickListener{
            val action = TaskHomeFragmentDirections.actionHomeToUpdate(currentTask)
            holder.itemView.findNavController().navigate(action)
        }
    }

    override fun getItemCount(): Int {
        return taskList.size
    }


    fun setData(task: List<Task>) {
        this.taskList = task
        notifyDataSetChanged()
    }
}


