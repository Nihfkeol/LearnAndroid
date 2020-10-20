package com.example.androidviewmodel

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.androidviewmodel.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val myViewModel by viewModels<MyViewModel>()

    //    private lateinit var myViewModel: MyViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
//        myViewModel = ViewModelProvider(this, SavedStateViewModelFactory(application, this)).get(MyViewModel::class.java)
        binding.data = myViewModel
        binding.lifecycleOwner = this
    }

    override fun onPause() {
        super.onPause()
        myViewModel.save()
    }
}