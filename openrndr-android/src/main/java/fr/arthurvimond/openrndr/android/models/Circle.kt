package fr.arthurvimond.openrndr.android.models

import fr.arthurvimond.openrndr_android.draw.DrawStyle

class Circle constructor(
    val x: Float,
    val y: Float,
    val radius: Float,
    override val drawStyle: DrawStyle
) : Drawable