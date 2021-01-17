package fr.arthurvimond.openrndr.android.extensions

import android.graphics.Color
import fr.arthurvimond.openrndr_android.color.ColorRGBa

val ColorRGBa.toPaintColorRGB: Int
    get() = Color.rgb(
        r.toInt() * 255,
        g.toInt() * 255,
        b.toInt() * 255
    )