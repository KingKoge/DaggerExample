package me.developer.suttichai.dagger

import android.app.Application
import android.content.Context
import androidx.multidex.MultiDex
import me.developer.suttichai.dagger.db.DatabaseManager

class MainApplication : Application() {

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }

    override fun onCreate() {
        super.onCreate()
        DatabaseManager.init(this)
    }
}