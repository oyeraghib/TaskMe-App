package com.example.taskme.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.taskme.database.models.Task


@Dao
interface TaskDao {

    //Inserting Task
    @Insert
    suspend fun insertTask(task: Task)

    //Updating Task
    @Update
    suspend fun updateTask(task: Task)

    //Deleting single task
    @Delete()
    suspend fun deleteTask(task: Task)

//    //Deleting all tasks
//    @Delete
//    suspend fun deleteAllTasks()

    //Reading all task from the table
    @Query("select * from task_table order by id asc")
    fun getAllTasks(): LiveData<List<Task>>



}