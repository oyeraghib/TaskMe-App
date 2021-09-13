package com.example.taskme.data

import androidx.lifecycle.LiveData
import androidx.room.*


@Dao
interface TaskDao {

    @Insert
    suspend fun insertTask(task: Task)

    @Query("select * from task_table order by id desc")
    fun getAllTasks(): LiveData<List<Task>>



}