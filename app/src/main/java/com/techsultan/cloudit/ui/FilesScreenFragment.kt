package com.techsultan.cloudit.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.techsultan.cloudit.R
import com.techsultan.cloudit.databinding.FragmentFilesScreenBinding


class FilesScreenFragment : Fragment() {

    private var _binding: FragmentFilesScreenBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentFilesScreenBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.floatingActionButton.setOnClickListener {

            findNavController().navigate(R.id.action_filesScreenFragment_to_uploadFileFragment, null)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}