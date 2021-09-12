package com.example.taskme.repo

import com.example.taskme.data.Task
import com.example.taskme.data.TaskDao

class TaskRepo(private val dao: TaskDao) {


    val getAll = dao.getAllTasks()

    suspend fun insert(task: Task){
        dao.insertTask(task)
    }

    suspend fun update(task: Task){
        dao.updateTask(task)
    }

    suspend fun delete(task: Task) {
        dao.deleteTask(task)
    }

//    suspend fun delete(key: Int){
//        dao.deleteTask()
//    }


}