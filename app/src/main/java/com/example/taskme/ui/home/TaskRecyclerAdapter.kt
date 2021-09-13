package com.example.taskme.ui.home

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.taskme.data.Task
import com.example.taskme.databinding.ListItemTaskBinding
import com.example.taskme.repo.TaskRepo

class TaskRecyclerAdapter() :
    ListAdapter<Task, TaskRecyclerAdapter.TaskViewHolder>(TaskDiffCallBack()) {

    private var taskList = emptyList<Task>()

    class TaskViewHolder(val binding: ListItemTaskBinding) : RecyclerView.ViewHolder(binding.root)

    class TaskDiffCallBack: DiffUtil.ItemCallback<Task>() {
        override fun areItemsTheSame(oldItem: Task, newItem: Task): Boolean {
            return oldItem == newItem
        }

        @SuppressLint("DiffUtilEquals")
        override fun areContentsTheSame(oldItem: Task, newItem: Task): Boolean {
            return oldItem === newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {

        val inflater = parent.context.getSystemService(LayoutInflater::class.java)
        val binding = ListItemTaskBinding.inflate(inflater, parent, false)

        return TaskViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        val task = getItem(position)

        holder.binding.tvTitle.text = task.title
        holder.binding.tvTask.text = task.task
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setData(task: List<Task>){
        this.taskList = task
        notifyDataSetChanged()
    }
}