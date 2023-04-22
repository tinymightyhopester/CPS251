package com.ebookfrenzy.viewmodeldemo.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ebookfrenzy.viewmodeldemo.R

import com.ebookfrenzy.viewmodeldemo.databinding.MainFragmentBinding

class MainFragment : Fragment() {

    private var _binding: MainFragmentBinding? = null
    private val binding get() = _binding!!

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = MainFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        val resultObserver = Observer<String> { result ->
            binding.resultText.text = result
        }

        viewModel.getResult().observe(viewLifecycleOwner, resultObserver)

        binding.addButton.setOnClickListener {
            if (binding.nameText.text.isNotEmpty()) {
                viewModel.setName(binding.nameText.text.toString())
            } else {
                binding.resultText.text = getString(R.string.emptyText)
            }
        }
    }
}