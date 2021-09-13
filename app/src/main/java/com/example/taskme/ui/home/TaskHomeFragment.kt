package com.example.taskme.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.taskme.R
import com.example.taskme.databinding.FragmentTaskHomeBinding
import com.example.taskme.viewmodel.TaskViewModel

class TaskHomeFragment : Fragment() {

    private lateinit var binding: FragmentTaskHomeBinding
    private val taskListAdapter = TaskRecyclerAdapter()
    private lateinit var taskViewModel : TaskViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentTaskHomeBinding.inflate(inflater, container, false)
        //Recycler View
        binding.rvTask.layoutManager = LinearLayoutManager(requireContext())
        binding.rvTask.adapter = taskListAdapter

        //ViewModel
        taskViewModel = ViewModelProvider(this).get(TaskViewModel::class.java)

        taskViewModel.readAllData.observe(viewLifecycleOwner){
            taskListAdapter.setData(it)
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.fabTaskHome.setOnClickListener{
            findNavController().navigate(R.id.actionHomeToAdd) }


    }
}
