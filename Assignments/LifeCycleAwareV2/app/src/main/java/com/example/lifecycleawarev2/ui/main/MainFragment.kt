package com.example.lifecycleawarev2.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.lifecycleawarev2.DemoObserver
import com.example.lifecycleawarev2.R
import androidx.lifecycle.Observer
import androidx.lifecycle.SavedStateViewModelFactory
import com.example.lifecycleawarev2.databinding.ActivityMainBinding

class MainFragment : Fragment() {

    private lateinit var _binding: ActivityMainBinding
    private val binding get() = _binding!!

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = ActivityMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        lifecycle.addObserver(DemoObserver())
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        val resultObserver = Observer<String> { result ->
            viewModel.setData(lifecycle.currentState.name)
        }

        viewModel.getResult().observe(viewLifecycleOwner, resultObserver)

    }
}