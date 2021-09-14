package com.example.taskme.repo

import androidx.lifecycle.LiveData
import com.example.taskme.database.models.Task
import com.example.taskme.database.TaskDao

class TaskRepo(private val taskdao: TaskDao) {

   val readAllData: LiveData<List<Task>> = taskdao.getAllTasks()

    suspend fun addTask(task: Task){
        taskdao.insertTask(task)
    }

    suspend fun updateTask(task: Task){
        taskdao.updateTask(task)
    }
}