package com.example.inflearn_livedata_viewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.example.inflearn_livedata_viewmodel.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        val viewModel : MainViewModel by viewModels()

        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        binding.btnNextWord.setOnClickListener {
            viewModel.getNextWord()
        }

    }
}