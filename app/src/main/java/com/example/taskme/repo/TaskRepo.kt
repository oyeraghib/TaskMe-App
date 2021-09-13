package com.example.taskme.repo

import androidx.lifecycle.LiveData
import com.example.taskme.data.Task
import com.example.taskme.data.TaskDao

class TaskRepo(private val taskdao: TaskDao) {

   val readAllData: LiveData<List<Task>> = taskdao.getAllTasks()

    suspend fun addTask(task: Task){
        taskdao.insertTask(task)
    }
}