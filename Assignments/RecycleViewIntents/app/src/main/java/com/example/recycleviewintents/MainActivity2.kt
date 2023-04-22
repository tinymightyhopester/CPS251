package com.example.recycleviewintents

import android.os.Bundle
import android.content.Intent
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.recycleviewintents.databinding.ContentMain2Binding


class MainActivity2 : AppCompatActivity() {

    private lateinit var binding: ContentMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ContentMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)


    }

}