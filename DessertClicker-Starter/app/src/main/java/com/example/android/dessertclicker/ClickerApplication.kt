package com.example.android.dessertclicker

import android.app.Application
import timber.log.Timber

/**
 * Initialize Timber library for the Activities
 */

class ClickerApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        Timber.plant(Timber.DebugTree())
    }
}