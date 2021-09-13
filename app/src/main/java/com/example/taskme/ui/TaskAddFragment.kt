package com.example.taskme.ui

import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.util.LogPrinter
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.taskme.R
import com.example.taskme.data.Task
import com.example.taskme.data.TaskDatabase
import com.example.taskme.databinding.FragmentTaskAddBinding
import com.example.taskme.repo.TaskRepo
import java.security.PrivateKey


class TaskAddFragment : Fragment() {

    private lateinit var binding: FragmentTaskAddBinding
    private lateinit var taskViewModel: TaskViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragmen

        binding = FragmentTaskAddBinding.inflate(inflater, container, false)

        taskViewModel = ViewModelProvider(this).get(TaskViewModel::class.java)

        binding.fabTaskAdd.setOnClickListener{
            insertDataToDatabase()
            findNavController().navigate(R.id.actionAddToHome)
        }
        return binding.root
    }

    private fun insertDataToDatabase() {

        val title = binding.etTitle.text.toString()
        val task = binding.etTask.text.toString()

        if(inputCheck(title, task)){
            //Create Task
            val _task = Task(0, title, task)

            //Add data to database
            taskViewModel.addTask(_task)
            Toast.makeText(requireContext(), "Successfully added", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(requireContext(), "Please fill out all fields", Toast.LENGTH_SHORT).show()
        }
    }

    private fun inputCheck(title: String, task: String): Boolean{
        return !(TextUtils.isEmpty(title) && TextUtils.isEmpty(task))
    }


}