package com.lega.atstaff

import android.app.Application
import com.lega.atstaff.ui.util.Prefs
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class ATStaffApp:Application(){

    companion object{
        lateinit var prefs: Prefs
    }

    override fun onCreate() {
        super.onCreate()
        prefs = Prefs(applicationContext)
    }
}