package com.example.roomdemo.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.roomdemo.Product
import androidx.fragment.app.viewModels
import java.util.*
import com.example.roomdemo.databinding.FragmentMainBinding
import com.example.roomdemo.R

class MainFragment : Fragment() {

    private var adapter: ProductListAdapter? = null

    companion object {
        fun newInstance() = MainFragment()
    }

    val viewModel: MainViewModel by viewModels()
    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        listenerSetup()
        observerSetup()
        recyclerSetup()
    }

    private fun clearFields() {
        binding.productID.text = ""
        binding.productName.setText("")
        binding.productQuantity.setText("")
    }

    private fun listenerSetup() {
        binding.addButton.setOnClickListener {
            val name = binding.productName.text.toString()
            val quantity = binding.productQuantity.text.toString()
            if (name != "" && quantity != "") {
                val product = Product(name, Integer.parseInt(quantity))
                viewModel.insertProduct(product)
                clearFields()
            } else {
                binding.productID.text = "Incomplete information"
            }
        }
        binding.findButton.setOnClickListener { viewModel.findProduct(
            binding.productName.text.toString()) }
        binding.deleteButton.setOnClickListener {
            viewModel.deleteProduct(binding.productName.text.toString())
            clearFields()
        }
    }

    private fun observerSetup() {
        viewModel.getAllProducts()?.observe(this.viewLifecycleOwner, Observer { products ->
            products?.let {
                adapter?.setProductList(it)
            }
        })
        viewModel.getSearchResults().observe(this.viewLifecycleOwner, Observer { products ->
            products?.let {
                if (it.isNotEmpty()) {
                    binding.productID.text = String.format(Locale.US, "%d", it[0].id)
                    binding.productName.setText(it[0].productName)
                    binding.productQuantity.setText(String.format(Locale.US, "%d",
                        it[0].quantity))
                } else {
                    binding.productID.text = "No Match"
                }
            }
        })
    }

    private fun recyclerSetup() {
        adapter = ProductListAdapter(R.layout.product_list_item)
        binding.productRecycler.layoutManager = LinearLayoutManager(context)
        binding.productRecycler.adapter = adapter
    }

}