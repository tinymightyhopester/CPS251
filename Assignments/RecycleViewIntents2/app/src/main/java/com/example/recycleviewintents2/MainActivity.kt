package com.example.recycleviewintents2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recycleviewintents2.RecyclerAdapter
import com.example.recycleviewintents2.databinding.ContentMainBinding
import kotlin.properties.Delegates


class MainActivity : AppCompatActivity() {

    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerView.Adapter<RecyclerAdapter.ViewHolder>? = null
    private lateinit var binding: ContentMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ContentMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        layoutManager = LinearLayoutManager(this)
        binding.recyclerView.layoutManager = layoutManager
        adapter = RecyclerAdapter()
        binding.recyclerView.adapter = adapter
        val extras = intent.extras ?: return
        val imageID = extras.getInt("imageID")
        val title = extras.getString("title")
        val detail = extras.getString("detail")

        sendTo2(imageID,title.toString(),detail.toString())
    }

    fun sendTo2(imageID:Int, title:String, detail:String) {
        val intent2 = Intent(this, MainActivity2::class.java)
        intent2.putExtra("imageID",imageID)
        intent2.putExtra("title", title)
        intent2.putExtra("detail",detail)
        startActivity(intent2)
    }

}