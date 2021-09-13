package com.example.taskme.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "task_table")
data class Task(

    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val title: String,
    val task: String

)