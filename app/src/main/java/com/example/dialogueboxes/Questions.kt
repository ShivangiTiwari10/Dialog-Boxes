package com.example.dialogueboxes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.dialogueboxes.databinding.ActivityQuestionsBinding

class Questions : AppCompatActivity() {

    private lateinit var binding: ActivityQuestionsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuestionsBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}