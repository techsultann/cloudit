package com.techsultan.cloudit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.techsultan.cloudit.databinding.ActivityFileScreenBinding
import com.techsultan.cloudit.databinding.ActivityLoginScreenBinding
import com.techsultan.cloudit.databinding.ActivityUploadScreenBinding

class file_screen : AppCompatActivity() {

    private lateinit var binding: ActivityFileScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_file_screen)

        binding = ActivityFileScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)



    }
}