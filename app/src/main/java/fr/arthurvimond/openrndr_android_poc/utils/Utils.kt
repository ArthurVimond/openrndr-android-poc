package fr.arthurvimond.openrndr_android_poc.utils

import android.view.Window
import android.view.WindowManager

object Utils {

    fun fullscreen(window: Window) {
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
    }

    fun wakeLock(window: Window) {
        window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)
    }

}