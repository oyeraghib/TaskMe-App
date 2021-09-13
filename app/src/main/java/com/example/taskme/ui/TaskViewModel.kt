package com.example.taskme.ui

import android.app.Application
import androidx.lifecycle.*
import com.example.taskme.data.Task
import com.example.taskme.data.TaskDatabase
import com.example.taskme.repo.TaskRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TaskViewModel(application: Application) : AndroidViewModel(application){

    private val readAllData: LiveData<List<Task>>
    private val repository: TaskRepo

    init {
        val taskDao = TaskDatabase.getDatabase(application).taskDao()
        repository = TaskRepo(taskDao)
        readAllData = repository.readAllData
    }

    fun addTask(task: Task){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addTask(task)
        }
    }

}

