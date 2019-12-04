package com.bar.koinpoc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_sharedprefs.setOnClickListener {
            Toast.makeText(this, "shared prefs", Toast.LENGTH_SHORT).show()
        }

        btn_savetodb.setOnClickListener {
            Toast.makeText(this, "save to db", Toast.LENGTH_SHORT).show()
        }

        btn_network.setOnClickListener {
            Toast.makeText(this, "network", Toast.LENGTH_SHORT).show()
        }



    }
}
