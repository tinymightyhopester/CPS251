package com.example.coroutines

import androidx.recyclerview.widget.RecyclerView
import kotlin.collections.ArrayList



class Data {

    private var adapter: RecyclerView.Adapter<RecyclerAdapter.ViewHolder>? = null

    fun getTimes(): LongArray {
        return times.toList().shuffled().toLongArray()
    }

    fun getNames(): ArrayList<String>{
        return names
    }

    fun addName(name:String) {
        names.add(name)
    }

    fun updateList(newList:ArrayList<String>){
        names.clear()
        names.addAll(newList)
        adapter!!.notifyDataSetChanged()

    }



    private val times = longArrayOf(1_000,2_000,3_000,4_000,5_000,6_000,7_000,8_000,9_000,10_000)

    private val names = arrayListOf("")
}