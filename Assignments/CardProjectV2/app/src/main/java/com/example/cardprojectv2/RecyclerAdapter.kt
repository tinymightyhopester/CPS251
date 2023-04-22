package com.example.cardprojectv2

import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.TextView
import android.view.View
import android.view.ViewGroup
import com.google.android.material.snackbar.Snackbar
import androidx.recyclerview.widget.RecyclerView
import com.example.cardprojectv2.Data
import com.example.cardprojectv2.R

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
                var position: Int = getAdapterPosition()
                Snackbar.make(v, "Click detected on item $position",
                    Snackbar.LENGTH_LONG).setAction("Action", null).show()
            }
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val v = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.card_layout, viewGroup, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {

        if (viewHolder.itemTitle.equals("")) {
            titles.shuffle()
            details.shuffle()
            images.shuffle()
            viewHolder.itemTitle.text = titles[i]
            viewHolder.itemDetail.text = details[i]
            viewHolder.itemImage.setImageResource(images[i])
        }
    }

    override fun getItemCount(): Int {
        return titles.size
    }

    var data = Data()
    private val titles = data.getTitles()

    private val details = data.getDetails()

    private val images = data.getImages()

}