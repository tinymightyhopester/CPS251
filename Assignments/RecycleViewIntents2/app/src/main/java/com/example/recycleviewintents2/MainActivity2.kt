package com.example.recycleviewintents2

import android.os.Bundle
import android.content.Intent
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.recycleviewintents2.databinding.ContentMain2Binding


class MainActivity2 : AppCompatActivity() {

    private lateinit var binding: ContentMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ContentMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        val extras = intent.extras ?: return
        val imageID = extras.getInt("imageID")
        val title = extras.getString("title")
        val detail = extras.getString("detail")

        binding.imageView2.setImageResource(imageID)
        binding.titleText2.text = title
        binding.detailsText2.text = detail

    }

}