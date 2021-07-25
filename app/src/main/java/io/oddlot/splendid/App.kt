package io.oddlot.splendid

import android.app.Application
import android.content.SharedPreferences
import androidx.preference.PreferenceManager

//import io.oddlot.splendid.data.AppDatabase

class App : Application() {
//    lateinit var appDatabase: AppDatabase
//    lateinit var appPrefs:

    companion object {
//        @Volatile
//        lateinit var db: AppDatabase
        lateinit var prefs: SharedPreferences
    }

    override fun onCreate() {
        super.onCreate()

        prefs = applicationContext.getSharedPreferences("io.oddlot.splendid", MODE_PRIVATE)
    }
}