package com.example.dialogueboxes

import android.annotation.SuppressLint
import android.content.DialogInterface
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextThemeWrapper
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.dialogueboxes.databinding.ActivityMainBinding
import java.util.*
import kotlin.collections.ArrayList

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

        binding.btnAlertWithMultiChoiceList.setOnClickListener {
            withMultiChoiceList()
        }

        binding.btnAlertWithStyle.setOnClickListener {
            withStyle()
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

    //    4. Alert Dialog With MultiChoice List
    private fun withMultiChoiceList() {

        val items = arrayOf("Microsoft", "Apple", "Amazon", "Google")
        val selectedList = ArrayList<Int>()
        val builder = AlertDialog.Builder(this)

        builder.setTitle("This is list choice dialog box")
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

    //   5. Alert Dialog With Style
    fun withStyle() {

        val builder =
            AlertDialog.Builder(ContextThemeWrapper(this, android.R.style.Holo_SegmentedButton))

        with(builder)
        {
            setTitle("Androidly Alert")
            setMessage("We have a message")
            setPositiveButton("OK", DialogInterface.OnClickListener(function = positiveButtonClick))
            setNegativeButton("No", negativeButtonClick)
            setNeutralButton("Maybe", neutralButtonClick)
            show()
        }
    }


}