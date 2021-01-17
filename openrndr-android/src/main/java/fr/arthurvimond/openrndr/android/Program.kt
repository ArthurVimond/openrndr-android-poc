package fr.arthurvimond.openrndr.android

import android.graphics.Canvas

class Program {

    val drawer = Drawer()

    val extensions = mutableListOf<Extension>()

    /**
     * Install an extension function for the given [ExtensionStage]
     */
    fun extend(stage: ExtensionStage = ExtensionStage.BEFORE_DRAW, userDraw: Program.() -> Unit) {
        val functionExtension = when (stage) {
            ExtensionStage.SETUP ->
                object : Extension {
                    override var enabled: Boolean = true
                    override fun setup(program: Program) {
                        program.userDraw()
                    }
                }
            ExtensionStage.BEFORE_DRAW ->
                object : Extension {
                    override var enabled: Boolean = true
                    override fun beforeDraw(drawer: Drawer, program: Program) {
                        program.userDraw()
                    }
                }
            ExtensionStage.AFTER_DRAW ->
                object : Extension {
                    override var enabled: Boolean = true
                    override fun afterDraw(drawer: Drawer, program: Program) {
                        program.userDraw()
                    }
                }
        }
        extensions.add(functionExtension)
    }

    fun draw(canvas: Canvas) {
        extensions.filter { it.enabled }.forEach { it.beforeDraw(drawer, this) }
        drawer.draw(canvas)
        extensions.reversed().filter { it.enabled }.forEach { it.afterDraw(drawer, this) }
    }

}