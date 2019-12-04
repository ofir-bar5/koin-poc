package com.bar.koinpoc.koin

import android.content.Context
import androidx.room.Room
import com.bar.koinpoc.room.WordRoomDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val applicationModule = module {
    // Single instance of shared preference
    single { androidContext().getSharedPreferences("default", Context.MODE_PRIVATE)}
    single { Room.databaseBuilder(androidContext(), WordRoomDatabase::class.java, "word_database").build() }
}