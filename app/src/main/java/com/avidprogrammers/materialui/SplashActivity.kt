package com.avidprogrammers.materialui

import android.annotation.SuppressLint
import android.app.Activity
import android.content.res.Configuration
import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.google.android.material.color.DynamicColors


@SuppressLint("CustomSplashScreen")
class SplashActivity : Activity() {
    @RequiresApi(Build.VERSION_CODES.S)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //For having a SplashScreen API
        installSplashScreen()
        //For applying dynamic colors in the project
        DynamicColors.applyToActivitiesIfAvailable(application)

        when (resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK) {
            Configuration.UI_MODE_NIGHT_NO -> {
                //Night mode is not active
                setTheme(R.style.Theme_MaterialDay)
            }
            Configuration.UI_MODE_NIGHT_YES -> {
                //Night mode is active
                setTheme(R.style.Theme_MaterialNight)
            }
        }
        setContentView(R.layout.activity_main)
    }
}
