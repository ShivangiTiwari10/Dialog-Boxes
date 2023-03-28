package com.example.dialogueboxes

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.dialogueboxes.databinding.ActivityQuestionsBinding
import java.util.*
import kotlin.collections.ArrayList

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

        binding.question2.setOnClickListener {


            val items = arrayOf("Data security", "Data integrity", "Data independence", "All")
            val selectedList = ArrayList<Int>()
            val builder = AlertDialog.Builder(this)

            builder.setTitle("Which of the following is handled by DBMS?")
            builder.setMultiChoiceItems(
                items, null
            ) { dialog, which, isChecked ->
                if (isChecked) {
                    selectedList.add(which)
                } else if (selectedList.contains(which)) {
                    selectedList.remove(Integer.valueOf(which))
                }
            }

            builder.setPositiveButton("DONE") { dialogInterface, i ->
                val selectedStrings = ArrayList<String>()

                for (j in selectedList.indices) {
                    selectedStrings.add(items[selectedList[j]])
                }

                Toast.makeText(
                    applicationContext,
                    "Items selected are: " + Arrays.toString(selectedStrings.toTypedArray()),
                    Toast.LENGTH_SHORT
                ).show()
            }

            builder.show()

        }
        setContentView(binding.root)
    }
}