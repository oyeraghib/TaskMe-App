package com.example.taskme.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.taskme.database.models.Task


@Dao
interface TaskDao {

    @Insert
    suspend fun insertTask(task: Task)

    @Update
    suspend fun updateTask(task: Task)

    @Query("select * from task_table order by id desc")
    fun getAllTasks(): LiveData<List<Task>>



}