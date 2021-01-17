package fr.arthurvimond.openrndr_android_poc

import fr.arthurvimond.openrndr.android.application
import fr.arthurvimond.openrndr_android.color.ColorRGBa

fun templateApplication() = application {

    program {

        var circlePosX = 0

        extend {
            drawer.clear(ColorRGBa.BLACK)

            circlePosX += 1

            drawer.stroke = null
            drawer.fill = ColorRGBa.GREEN
            drawer.circle(200.0, 300.0, 30.0)

            drawer.fill = ColorRGBa.YELLOW
            drawer.rectangle(300.0, 100.0, 100.0, 100.0)

            drawer.fill = null
            drawer.stroke = ColorRGBa.BLUE
            drawer.strokeWeight = 10.0
            drawer.circle(circlePosX.toDouble(), 200.0, 90.0)

        }
    }


}