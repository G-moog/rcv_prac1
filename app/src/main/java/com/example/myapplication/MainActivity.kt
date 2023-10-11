package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val fooAdapter by lazy {
        FooAdapter {

        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        // lateinit
        // fooAdapter = FooAdapter {}
        binding.recyclerView.adapter = fooAdapter
        fooAdapter.addItems(Foo.createSamples(0))
    }
}