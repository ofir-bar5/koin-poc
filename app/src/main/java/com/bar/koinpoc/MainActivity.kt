package com.bar.koinpoc

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.bar.koinpoc.room.Word
import com.bar.koinpoc.room.WordDao
import com.bar.koinpoc.room.WordRoomDatabase
import com.bar.koinpoc.simple_object.Watermelon
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {

    private val sharedPrefs : SharedPreferences by inject()
    private val wordRoomDatabase : WordRoomDatabase by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sharedPrefsEditor = sharedPrefs.edit()
        val wordDao : WordDao = wordRoomDatabase.wordDao()

        btn_sharedprefs.setOnClickListener {
            val rands = (0..500000).random()
            sharedPrefsEditor.putInt("key", rands)
            sharedPrefsEditor.apply()
            toast("saved to share prefs")
        }

        btn_savetodb.setOnClickListener {
            val rands = (0..10000).random()
            Thread(Runnable {
                wordDao.insert(Word("Word${rands}"))
                Log.e("Thread", "{wordDao.insert() at ${Thread.currentThread().name}}")
            }).start()

            toast("saved to db")
        }

        btn_simple_object.setOnClickListener {
            val watermelon : Watermelon by inject()
            toast(watermelon.toString())
        }


        // Toast Buttons
        btn_toast_sharedprefs.setOnClickListener {
            toast(sharedPrefs.getInt("key", -1).toString())
        }
        btn_toast_db.setOnClickListener {
            Thread(Runnable {
                val listOfWords : List<Word> = wordDao.getAlphabetizedWords()
                Log.e("Thread", "getAlphabetizedWords ${Thread.currentThread().name}}")
                for ( word in listOfWords){
                    Log.e("list of words:", word.word)
                }
            }).start()
        }
    }

    private fun toast(msg : String){
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }


}
