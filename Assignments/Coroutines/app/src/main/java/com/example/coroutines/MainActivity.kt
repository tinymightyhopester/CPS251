package com.example.coroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.coroutines.databinding.ActivityMainBinding
import kotlinx.coroutines.*
import java.io.IOException
import java.io.InputStream

class MainActivity : AppCompatActivity() {

    private val coroutineScope = CoroutineScope(Dispatchers.Main)
    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerView.Adapter<RecyclerAdapter.ViewHolder>? = null
    private lateinit var binding: ActivityMainBinding
    private var data = Data()
    var theseNames = data.getNames()



//    suspend fun performTask(tasknumber: Int): Deferred<String> =
//        coroutineScope.async(Dispatchers.Main) {
//            val millis: LongArray = data.getTimes()
//            val thisSecond = millis[1]
//            delay(thisSecond)
//            return@async "Finished Coroutine ${tasknumber}"
//        }


    fun launchCoroutines(view: View) {
        var newName = binding.enterName.toString()
        //if (newName.isNotEmpty()) {
            data.addName(newName)
            coroutineScope.launch(Dispatchers.Main) {
                adapter!!.notifyDataSetChanged()
            }
        //}
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        layoutManager = LinearLayoutManager(this)
        binding.recyclerView.layoutManager = layoutManager
        adapter = RecyclerAdapter()
        binding.recyclerView.adapter = adapter

        try {
            val myInputStream: InputStream
            val myOutput: String
            myInputStream = assets.open("Names.txt")
            val size: Int = myInputStream.available()
            val buffer = ByteArray(size)
            myInputStream.read(buffer)
            myOutput = String(buffer)

            theseNames.addAll(listOf(myOutput))
        } catch (e: IOException) {
            e.printStackTrace()
        }

        binding.button.setOnClickListener {
            var newName = binding.enterName.toString()

            //theseNames.add(newName)
            //data.updateList(theseNames)
            //adapter!!.notifyDataSetChanged()
        }

    }
}