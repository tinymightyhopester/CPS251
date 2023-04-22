package com.example.contactsv2.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView

import com.example.contactsv2.Contact
import com.example.contactsv2.R

class ContactListAdapter (private val contactItemLayout: Int) :

    RecyclerView.Adapter<ContactListAdapter.ViewHolder>() {

    private var contactList: List<Contact>? = null
    private var newContactList: LiveData<List<Contact>>? = null

    override fun onBindViewHolder(holder: ViewHolder, listPosition: Int) {
        val item = holder.item
        val item2 = holder.item2
        contactList.let {
            item.text = it!![listPosition].contactName
            item2.text = it!![listPosition].contactPhone
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            contactItemLayout, parent, false)
        return ViewHolder(view)
    }

    fun setContactList(contacts: List<Contact>) {
        contactList = contacts
        notifyDataSetChanged()
    }

    fun setNewContactList(contacts: LiveData<List<Contact>>?) {
        newContactList = contacts
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return if (contactList == null) 0 else contactList!!.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var item: TextView = itemView.findViewById(R.id.contact_row)
        var item2: TextView = itemView.findViewById(R.id.contact_number)
    }
}