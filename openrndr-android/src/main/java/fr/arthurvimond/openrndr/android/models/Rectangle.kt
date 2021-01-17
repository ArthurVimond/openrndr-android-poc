package fr.arthurvimond.openrndr.android.models

import fr.arthurvimond.openrndr_android.draw.DrawStyle

class Rectangle constructor(
    val x: Float,
    val y: Float,
    val width: Float,
    val height: Float,
    override val drawStyle: DrawStyle
) : Drawable {

    val left = x
    val right = x + width
    val top = y
    val bottom = y + height
}