package io.oddlot.splendid

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import androidx.room.Room
import io.oddlot.splendid.data.SplendidDatabase

//import io.oddlot.splendid.data.AppDatabase

class SplendidApp : Application() {

    init {
        instance = this
    }

    companion object {
        private var instance: SplendidApp? = null

        val db: SplendidDatabase? by lazy {
            Room.databaseBuilder(applicationContext(), SplendidDatabase::class.java, "splendid").build()
        }

        lateinit var prefs: SharedPreferences

        fun applicationContext() : Context {
            return instance!!.applicationContext
        }
    }

    override fun onCreate() {
        super.onCreate()

//        prefs = applicationContext.getSharedPreferences("io.oddlot.splendid", MODE_PRIVATE)
    }
}