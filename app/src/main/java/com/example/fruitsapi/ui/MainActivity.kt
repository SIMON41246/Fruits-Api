package com.example.fruitsapi.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.fruitsapi.databinding.ActivityMainBinding
import com.example.fruitsapi.viewModel.MainViewModel

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        val viewModel: MainViewModel by viewModels()
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        viewModel.getFruitsInfo()

        viewModel.listfruits.observe(this) {
            if (it != null) {
                val adapter = Adapter(this, it)
                binding.recycle.adapter = adapter
                adapter.notifyDataSetChanged()
            }
        }
    }

}

