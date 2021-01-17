package fr.arthurvimond.openrndr.android

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import fr.arthurvimond.openrndr.android.extensions.toPaintColorRGB
import fr.arthurvimond.openrndr.android.models.Circle
import fr.arthurvimond.openrndr.android.models.Drawable
import fr.arthurvimond.openrndr.android.models.Rectangle
import fr.arthurvimond.openrndr_android.color.ColorRGBa
import fr.arthurvimond.openrndr_android.draw.DrawStyle

class Drawer {

    var drawStyle = DrawStyle()

    private var paint: Paint = Paint()

    private var backgroundColor: Int = Color.TRANSPARENT
    private val drawables: MutableList<Drawable> = mutableListOf()

    init {
        paint.isAntiAlias = true
        paint.isDither = true
        paint.style = Paint.Style.FILL
        paint.color = Color.BLUE
        paint.strokeWidth = 10f
    }

    /**
     * The active fill color
     * @see stroke
     * @see strokeWeight
     */
    var fill: ColorRGBa?
        set(value) {
            drawStyle.fill = value
        }
        get() = drawStyle.fill

    /**
     * The active stroke color
     * @see fill
     */
    var stroke: ColorRGBa?
        set(value) {
            drawStyle.stroke = value
        }
        get() = drawStyle.stroke

    /**
     * The active stroke weight
     * @see stroke
     */
    var strokeWeight: Double
        set(value) {
            drawStyle.strokeWeight = value
        }
        get() = drawStyle.strokeWeight


    fun clear(color: ColorRGBa) {
        backgroundColor = color.toPaintColorRGB
    }


    fun circle(x: Double, y: Double, radius: Double) {
        val drawStyle = drawStyle.copy()
        val circle = Circle(
            x = x.toFloat(),
            y = y.toFloat(),
            radius = radius.toFloat(),
            drawStyle = drawStyle
        )
        drawables.add(circle)
    }

    fun rectangle(x: Double, y: Double, width: Double, height: Double) {
        val drawStyle = drawStyle.copy()
        val rectangle = Rectangle(
            x = x.toFloat(),
            y = y.toFloat(),
            width = width.toFloat(),
            height = height.toFloat(),
            drawStyle = drawStyle
        )
        drawables.add(rectangle)
    }

    fun draw(canvas: Canvas) {

        canvas.drawColor(backgroundColor)

        drawables.forEach { drawable ->
            val drawStyle = drawable.drawStyle
            setPaint(drawStyle)
            when (drawable) {
                is Circle -> {
                    canvas.drawCircle(drawable.x, drawable.y, drawable.radius, paint)
                }
                is Rectangle -> {
                    canvas.drawRect(
                        drawable.left,
                        drawable.top,
                        drawable.right,
                        drawable.bottom,
                        paint
                    )
                }
            }
        }

        clearDrawables()
    }

    private fun setPaint(drawStyle: DrawStyle) {
        if (drawStyle.fill != null) {
            paint.style = Paint.Style.FILL
            paint.color = drawStyle.fill!!.toPaintColorRGB
        } else if (drawStyle.stroke != null) {
            paint.style = Paint.Style.STROKE
            paint.strokeWidth = drawStyle.strokeWeight.toFloat()
            paint.color = drawStyle.stroke!!.toPaintColorRGB
        }
    }

    private fun clearDrawables() {
        drawables.clear()
    }

}