package com.example.taskme.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query


@Dao
interface TaskDao {

    @Insert
    fun insertTask(task: Task)

    @Query("select * from task_table order by id desc")
    fun getAllTasks(): LiveData<List<Task>>

    @Insert
    fun insertMultipleTasks(vararg task: Task)
}