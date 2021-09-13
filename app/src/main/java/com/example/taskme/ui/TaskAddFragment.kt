package com.example.taskme.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.taskme.R
import com.example.taskme.data.TaskDatabase
import com.example.taskme.databinding.FragmentTaskAddBinding
import com.example.taskme.repo.TaskRepo


class TaskAddFragment : Fragment() {

    private lateinit var binding: FragmentTaskAddBinding
    private lateinit var taskViewModel: TaskViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_task_add, container, false)
        taskViewModel = ViewModelProvider(this).get(TaskViewModel::class.java)

        binding.viewModel = taskViewModel
        return binding.root
    }


}