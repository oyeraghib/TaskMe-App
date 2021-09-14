package com.example.taskme.viewmodel

import android.app.Application
import androidx.lifecycle.*
import com.example.taskme.database.models.Task
import com.example.taskme.database.TaskDatabase
import com.example.taskme.repo.TaskRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TaskViewModel(application: Application) : AndroidViewModel(application) {

    val readAllData: LiveData<List<Task>>
    private val repository: TaskRepo

    init {
        val taskDao = TaskDatabase.getDatabase(application).taskDao()
        repository = TaskRepo(taskDao)
        readAllData = repository.readAllData
    }

    fun addTask(task: Task) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addTask(task)
        }
    }

    fun updateTask(task: Task) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateTask(task)
        }
    }


}

