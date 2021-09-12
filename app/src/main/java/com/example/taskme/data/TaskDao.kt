package com.example.taskme.data

import androidx.lifecycle.LiveData
import androidx.room.*


@Dao
interface TaskDao {

    @Insert
    suspend fun insertTask(task: Task)

    @Update
    suspend fun updateTask(task: Task)

    @Query("select * from task_table order by id desc")
    fun getAllTasks(): LiveData<List<Task>>

    @Delete
    suspend fun deleteTask(task: Task)

    @Query("delete from task_table")
    suspend fun deleteAllTasks()



}