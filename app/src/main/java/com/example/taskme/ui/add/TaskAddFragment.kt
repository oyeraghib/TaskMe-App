package com.example.taskme.ui.add

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.taskme.R
import com.example.taskme.database.models.Task
import com.example.taskme.databinding.FragmentTaskAddBinding
import com.example.taskme.viewmodel.TaskViewModel


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

        binding.taskAdd.setOnClickListener{
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