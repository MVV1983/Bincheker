package com.example.bincheker.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.navigation.findNavController
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.bincheker.R

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupActionBarWithNavController(findNavController(R.id.fragment))
    }

    override fun onSupportNavigateUp(): Boolean {
        val navcontroller = findNavController(R.id.fragment)
        return navcontroller.navigateUp() || super.onSupportNavigateUp()
    }

    fun exitDialog() {
        AlertDialog.Builder(this, R.style.Theme_Bincheker).apply {
            setTitle("DAta recieved - Please confirm.")
            setMessage("Are you want to exit the app?")

            setPositiveButton("Yes") { _, _ ->
                // if user press yes, then finish the current activity
                finishAffinity()
                finish()
            }

            setNegativeButton("No") { _, _ ->
                // if user press no, then return the activity
                Toast.makeText(
                    this@MainActivity, "Thank you!",
                    Toast.LENGTH_LONG
                ).show()
            }

            setCancelable(true)
        }.create().show()
    }
}