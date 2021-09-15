package com.example.taskme.ui.home

import android.app.AlertDialog
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.taskme.R
import com.example.taskme.databinding.FragmentTaskHomeBinding
import com.example.taskme.viewmodel.TaskViewModel

class TaskHomeFragment : Fragment() {

    private lateinit var binding: FragmentTaskHomeBinding
    private val taskListAdapter = TaskRecyclerAdapter()
    private lateinit var taskViewModel: TaskViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentTaskHomeBinding.inflate(inflater, container, false)

        //Recycler View
        binding.rvTask.adapter = taskListAdapter
        binding.rvTask.layoutManager = LinearLayoutManager(requireContext())

        //ViewModel
        taskViewModel = ViewModelProvider(this).get(TaskViewModel::class.java)

        taskViewModel.readAllData.observe(viewLifecycleOwner) {
            taskListAdapter.setData(it)
        }

        //On Click FAB
        binding.fabTaskHome.setOnClickListener {
            findNavController().navigate(R.id.actionHomeToAdd)
        }

        //Adding Options Menu for deleting all tasks
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_delete, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.menu_delete){
            val builder = AlertDialog.Builder(requireContext())
                builder.setPositiveButton("Yes"){_,_ ->
                    taskViewModel.deleteAllTasks()
                    Toast.makeText(requireContext(), "Successfully removed all Tasks", Toast.LENGTH_SHORT).show()
                }
                builder.setNegativeButton("No"){_,_ ->
                }
                    builder.setTitle("Delete Everything ?")
                    builder.setMessage("Are you sure you want to delete all Tasks ?")
                    builder.create().show()
        }
        return super.onOptionsItemSelected(item)
    }
}
