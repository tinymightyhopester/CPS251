package com.example.recycleviewintents3

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.recycleviewintents3.databinding.ContentMain2Binding
import com.example.recycleviewintents3.images


class MainActivity2 : AppCompatActivity() {

    private lateinit var binding: ContentMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ContentMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val extras = intent.extras ?: return
        val image = images[extras.getInt("imagePosition")]
        val title = extras.getString("title")
        val detail = extras.getString("detail")
        binding.imageView2.setImageResource(image)
        binding.titleText2.text = title
        binding.detailsText2.text = detail

    }

}