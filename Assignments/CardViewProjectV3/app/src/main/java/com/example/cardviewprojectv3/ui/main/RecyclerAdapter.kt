package com.example.cardviewprojectv3.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cardviewprojectv3.R
import com.google.android.material.snackbar.Snackbar

var data = Data()
private val titles = data.getTitles()
private val details = data.getDetails()
private val images = data.getImages()

class RecyclerAdapter : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var itemImage: ImageView
        var itemTitle: TextView
        var itemDetail: TextView


        init {
            itemImage = itemView.findViewById(R.id.itemImage)
            itemTitle = itemView.findViewById(R.id.itemTitle)
            itemDetail = itemView.findViewById(R.id.itemDetail)

            itemView.setOnClickListener { v: View ->
                val position: Int = adapterPosition
                Snackbar.make(
                    v, "Click detected on item $position",
                    Snackbar.LENGTH_LONG
                ).setAction("Action", null).show()
            }
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {

        val v = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.card_layout, viewGroup, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {

            viewHolder.itemTitle.text = titles[i]
            viewHolder.itemDetail.text = details[i]
            viewHolder.itemImage.setImageResource(images[i])

    }

    override fun getItemCount(): Int {
        return titles.size
    }

}