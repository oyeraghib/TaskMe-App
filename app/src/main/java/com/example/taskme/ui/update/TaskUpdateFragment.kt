package com.example.taskme.ui.update

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.taskme.R
import com.example.taskme.database.models.Task
import com.example.taskme.databinding.FragmentTaskUpdateBinding
import com.example.taskme.viewmodel.TaskViewModel
import kotlinx.android.synthetic.main.fragment_task_add.*
import kotlinx.android.synthetic.main.fragment_task_update.*

class TaskUpdateFragment : Fragment() {

    private lateinit var binding: FragmentTaskUpdateBinding
    private lateinit var taskViewModel: TaskViewModel

    private val args by navArgs<TaskUpdateFragmentArgs>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = FragmentTaskUpdateBinding.inflate(inflater, container, false)

        binding.etTitleUpdate.setText(args.currentTask.title)
        binding.etTaskUpdate.setText(args.currentTask.task)

        taskViewModel = ViewModelProvider(this).get(TaskViewModel::class.java)

        binding.btnTaskUpdate.setOnClickListener {
            findNavController().navigate(R.id.actionUpdateToHome)
            updateTask()
        }

        binding.btnTaskUpdate
        return binding.root
    }

    private fun updateTask() {
        val title = etTitleUpdate.text.toString()
        val task = etTaskUpdate.text.toString()

        if (checkInput(title, task)) {
            //Create Task
            val updatedTask = Task(args.currentTask.id, title, task)

            //Add updated data to database
            taskViewModel.updateTask(updatedTask)
            Toast.makeText(requireContext(), "Successfully updated", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(requireContext(), "Please fill out all fields", Toast.LENGTH_SHORT)
                .show()
        }
    }


    private fun checkInput(title: String, task: String): Boolean {
        return !(TextUtils.isEmpty(title) && TextUtils.isEmpty(task))
    }
}

