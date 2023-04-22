package com.example.coroutines

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapter: RecyclerView.Adapter<RecyclerAdapter.ViewHolder>()  {

    var data = Data()
    var theseNames = data.getNames()

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var itemName: TextView
        //var enterName: TextView
        init {
            itemName = itemView.findViewById(R.id.name)
            //enterName = itemView.findViewById(R.id.enterName)
            //itemView.setOnClickListener { v ->
            //    itemName.text = enterName.text
            //}
        }

    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.card_layout, viewGroup, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemName.text = theseNames[position]
    }

    override fun getItemCount(): Int {
        return theseNames.size
    }
}