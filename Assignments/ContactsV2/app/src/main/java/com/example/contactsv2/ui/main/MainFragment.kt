package com.example.contactsv2.ui.main

import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.LiveData

import com.example.contactsv2.R
import com.example.contactsv2.Contact
import com.example.contactsv2.databinding.FragmentMainBinding

class MainFragment : Fragment() {

    private var adapter: ContactListAdapter? = null

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
        binding.contactName.setText("")
        binding.contactNumber.setText("")
    }

    private fun listenerSetup() {

        binding.addButton.setOnClickListener {
            val name = binding.contactName.text.toString()
            val number = binding.contactNumber.text.toString()
            if (name != "" && number != "") {
                val contact = Contact(name, number)
                viewModel.insertContact(contact)
                clearFields()
            } else {
                Toast.makeText(context, "Incomplete information", Toast.LENGTH_LONG).show()
            }
        }
        binding.findButton.setOnClickListener { viewModel.findContact(
            binding.contactName.text.toString())
            binding.contactNumber.text.toString()
            clearFields()
        }

        binding.ascButton.setOnClickListener {
            adapter?.setNewContactList(viewModel.getAllContactsASC())
        }

        binding.descButton.setOnClickListener {

        }

    }

    private fun observerSetup() {
        viewModel.getAllContacts()?.observe(this.viewLifecycleOwner, Observer { contacts ->
            contacts?.let {
                adapter?.setContactList(it)
            }
        })
        viewModel.getSearchResults().observe(this.viewLifecycleOwner, Observer { contacts ->
            contacts?.let {
                if (it.isNotEmpty()) {
                    binding.contactName.setText(it[0].contactName)
                    binding.contactNumber.setText(it[0].contactPhone)

                } else {
                    Toast.makeText(context, "No contacts found", Toast.LENGTH_LONG).show()
                }
            }
        })
        viewModel.getAllContactsASC()?.observe(this.viewLifecycleOwner, Observer{ contacts ->
            contacts?.let{ it ->
                //adapter?.setNewContactList(it)
            }
        })
    }

    private fun recyclerSetup() {
        adapter = ContactListAdapter(R.layout.contact_list_item)
        binding.contactRecycler.layoutManager = LinearLayoutManager(context)
        binding.contactRecycler.adapter = adapter
    }

}