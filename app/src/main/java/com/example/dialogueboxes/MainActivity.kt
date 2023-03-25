package com.example.dialogueboxes

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.dialogueboxes.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val positiveButtonClick = { dialog: DialogInterface, which: Int ->
        Toast.makeText(
            this, "Ok", Toast.LENGTH_SHORT
        ).show()
        finish()

    }
    private val negativeButtonClick = { dialog: DialogInterface, which: Int ->
        Toast.makeText(
            this, "Cancelled", Toast.LENGTH_SHORT
        ).show()
    }
    private val neutralButtonClick = { dialog: DialogInterface, which: Int ->
        Toast.makeText(
            this,
            "Maybe", Toast.LENGTH_SHORT
        ).show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.basicAlert.setOnClickListener {
            val builder = AlertDialog.Builder(this)

            with(builder)
            {
                setTitle("Android Alert")
                setMessage("Do you really want to exit ?")
                setPositiveButton(
                    "Yes",
                    DialogInterface.OnClickListener(function = positiveButtonClick)
                )
                setNegativeButton("No", negativeButtonClick)
                setNeutralButton("Maybe", neutralButtonClick)
                show()
            }

        }


    }

}