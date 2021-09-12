package com.example.taskme.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.taskme.data.Task
import com.example.taskme.repo.TaskRepo
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class TaskViewModel(private val repo: TaskRepo) : ViewModel() {

    private val tasks = repo.getAll


    val inputTitle = MutableLiveData<String>()
    val inputTask = MutableLiveData<String>()

//    val updateTaskOrTitle = MutableLiveData<String>()
//
//    val deleteTask = MutableLiveData<String>()
//
//    fun updateOrSaveTask(){
//
//    }

    fun insert(task: Task): Job = viewModelScope.launch {
        repo.insert(task)
    }

    fun update(task: Task): Job = viewModelScope.launch {
        repo.update(task)
    }

    fun delete(task: Task): Job = viewModelScope.launch {
        repo.delete(task)
    }



}