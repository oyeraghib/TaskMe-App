package com.example.taskme.data

import androidx.room.Entity


@Entity(tableName = "task_table")
data class Task(

    val id: Int,
    val title: String,
    val task: String

)