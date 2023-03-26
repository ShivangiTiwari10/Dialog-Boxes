package com.example.dialogueboxes

import android.annotation.SuppressLint
import android.content.DialogInterface
import android.graphics.Color
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


    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        1.Basic alert Dialog
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
//        2.Alert Dialog With Icons and Customisation

        binding.btnAlertWithIconsAndCustomize.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            with(builder) {
                setTitle("It will make Call")
                setMessage("Do You want to call Someone")
                setPositiveButton("OK", null)
                setNegativeButton("CANCEL", null)
                setNeutralButton("NEUTRAL", null)
                setPositiveButtonIcon(resources.getDrawable(android.R.drawable.ic_menu_call, theme))
                setIcon(resources.getDrawable(android.R.drawable.ic_dialog_alert, theme))
            }
            val alertDialog = builder.create()
            alertDialog.show()

            val button = alertDialog.getButton(DialogInterface.BUTTON_POSITIVE)
            with(button) {
                setBackgroundColor(getColor(R.color.teal_200))
                setPadding(0, 0, 20, 0)
                setTextColor(Color.WHITE)
            }
        }
        binding.btnAlertWithItems.setOnClickListener {
            withItems()

        }
    }

//   3. Alert Dialog With Items


    private fun withItems() {

        val items = arrayOf("Red", "Orange", "Yellow", "Blue")
        val builder = AlertDialog.Builder(this)
        with(builder)
        {
            setTitle("List of Items")
            setItems(items) { dialog, which ->
                Toast.makeText(applicationContext, items[which] + " is clicked", Toast.LENGTH_SHORT)
                    .show()
            }

            setPositiveButton("OK", positiveButtonClick)
            show()
        }
    }

}