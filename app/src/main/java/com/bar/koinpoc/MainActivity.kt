package com.bar.koinpoc

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sharedPref = getPreferences(Context.MODE_PRIVATE)
        val sharedPrefsEditor = sharedPref.edit()

        btn_sharedprefs.setOnClickListener {
            val rands = (0..500000).random()
            sharedPrefsEditor.putInt("key", rands)
            sharedPrefsEditor.apply()
            toast("saved to share prefs")
        }

        btn_savetodb.setOnClickListener {
            toast("save to db")
        }

        btn_network.setOnClickListener {
            toast("network")
        }


        // Toast Buttons
        btn_toast_sharedprefs.setOnClickListener {
            toast(sharedPref.getInt("key", -1).toString())
        }
        btn_toast_db.setOnClickListener {  }
    }

    private fun toast(msg : String){
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }
}
