@file:Suppress("DEPRECATION")

package com.example.navproject.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.navproject.databinding.FragmentMainBinding

class MainFragment : Fragment() {

    companion object;

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        binding.button.setOnClickListener {
            val action: MainFragmentDirections.MainToSecond =
                MainFragmentDirections.mainToSecond()
            action.message = binding.button.text.toString()
            Navigation.findNavController(it).navigate(action)
        }
        binding.button2.setOnClickListener {
            val action: MainFragmentDirections.MainToSecond =
                MainFragmentDirections.mainToSecond()
            action.message = binding.button2.text.toString()
            Navigation.findNavController(it).navigate(action)
        }
        binding.button3.setOnClickListener {
            val action: MainFragmentDirections.MainToSecond =
                MainFragmentDirections.mainToSecond()
            action.message = binding.button3.text.toString()
            Navigation.findNavController(it).navigate(action)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}