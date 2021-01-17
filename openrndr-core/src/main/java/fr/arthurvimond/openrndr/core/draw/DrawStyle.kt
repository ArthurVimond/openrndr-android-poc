package fr.arthurvimond.openrndr_android.draw

import fr.arthurvimond.openrndr_android.color.ColorRGBa

data class DrawStyle(

    /** Fill color, set to null for no fill */
    var fill: ColorRGBa? = ColorRGBa.WHITE,

    /** Stroke color, set to null for no stroke */
    var stroke: ColorRGBa? = ColorRGBa.BLACK,

    var strokeWeight: Double = 1.0
)