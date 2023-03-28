package com.example.dialogueboxes

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.dialogueboxes.databinding.ActivityQuestionsBinding
import java.util.*
import kotlin.collections.ArrayList

class Questions : AppCompatActivity() {

    private lateinit var binding: ActivityQuestionsBinding
    private lateinit var dialog: Dialog

    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuestionsBinding.inflate(layoutInflater)

        dialog = Dialog(this)
        dialog.setContentView(R.layout.custom_dialog)

//     To set drawable background
        dialog.window?.setBackgroundDrawable(getDrawable(R.drawable.bg_custom_box))


        binding.question1.setOnClickListener {
            val options = arrayOf("Python", "Java", "Kotlin", "C++")
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Which is your favourite Language?")
            builder.setSingleChoiceItems(
                options,
                0,
                DialogInterface.OnClickListener { dialogInterface, i ->

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

        binding.exit.setOnClickListener {
            val builder = AlertDialog.Builder(this)

            builder.setTitle("Are You Sure?")
            builder.setMessage("Do You want to exit?")
            builder.setIcon(R.drawable.ic_baseline_exit_to_app_24)
            builder.setPositiveButton("Yes") { _, i ->
                dialog.dismiss()
                finish()
            }

            builder.setNegativeButton("No") { _, i ->
                Toast.makeText(this, "you clicked on no", Toast.LENGTH_SHORT).show()
            }
            builder.show()
        }
//        val btnToDo = dialog.findViewById<Button>(R.id.button2)

        binding.cutumiseBox.setOnClickListener {
            dialog.show()
        }
//        to Axis custom_Dialog layot Items
        val btnToDo = dialog.findViewById<Button>(R.id.button2)
        btnToDo.setOnClickListener {
            Toast.makeText(this,"U Click ToDo",Toast.LENGTH_SHORT).show()
        }

        setContentView(binding.root)
    }
}