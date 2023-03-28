package com.example.dialogueboxes

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.dialogueboxes.databinding.ActivityQuestionsBinding

class Questions : AppCompatActivity() {

    private lateinit var binding: ActivityQuestionsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuestionsBinding.inflate(layoutInflater)


        binding.question1.setOnClickListener {
            val options = arrayOf("Python", "Java", "Kotlin","C++")
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Which is your favourite Language?")
            builder.setSingleChoiceItems(options,0,DialogInterface.OnClickListener { dialogInterface, i ->

                Toast.makeText(this, "You clicked on ${options[i]}", Toast.LENGTH_SHORT).show()

            })
            builder.setPositiveButton(
                "submit",
                DialogInterface.OnClickListener { dialogInterface, i -> })

            builder.setNegativeButton(
                "Decline",
                DialogInterface.OnClickListener { dialogInterface, i -> })


            builder.show()
        }
        setContentView(binding.root)
    }
}