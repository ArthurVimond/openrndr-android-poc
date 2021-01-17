package fr.arthurvimond.openrndr.android

class ApplicationBuilder internal constructor() {

    private lateinit var program: Program

    fun build(): Application {
        return Application(program)
    }

    fun program(block: Program.() -> Unit) {
        program = Program().apply(block)
    }

}

fun application(block: ApplicationBuilder.() -> Unit): Application =
    ApplicationBuilder().apply(block).build()