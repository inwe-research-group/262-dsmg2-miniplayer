package com.dsm.miniplayerg2

import android.app.Application
import android.util.Log
import com.dsm.miniplayerg2.di.loginModule
import com.dsm.miniplayerg2.di.signUpModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class MiniplayerG2App: Application() {
    override fun onCreate() {
        super.onCreate()
        Log.d("MiniplayerG2App", "onCreate started")
        try {
            startKoin {
                androidLogger(Level.DEBUG)
                androidContext(this@MiniplayerG2App)
                modules(
                    listOf(
                        loginModule,
                        signUpModule
                    )
                )
            }
            Log.d("MiniplayerG2App", "Koin started successfully")
        } catch (e: Exception) {
            Log.e("MiniplayerG2App", "Error starting Koin", e)
        }
    }
}