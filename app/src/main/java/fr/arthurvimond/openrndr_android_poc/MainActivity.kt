package fr.arthurvimond.openrndr_android_poc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import fr.arthurvimond.openrndr.android.ui.ORFragment
import fr.arthurvimond.openrndr_android_poc.utils.Utils

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Utils.fullscreen(window)
        Utils.wakeLock(window)

        val fragment = ORFragment.newInstance()
        val fragmentContainer = findViewById<FrameLayout>(R.id.fragmentContainer)

        fragment.setView(fragmentContainer, this)
        fragment.setApplication(templateApplication())
    }
}