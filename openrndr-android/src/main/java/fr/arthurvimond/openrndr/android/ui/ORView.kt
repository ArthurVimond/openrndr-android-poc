package fr.arthurvimond.openrndr.android.ui

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.SurfaceHolder
import android.view.SurfaceView
import fr.arthurvimond.openrndr.android.Application

internal class ORView : SurfaceView, Runnable {

    private lateinit var mContext: Context
    private lateinit var mSurfaceHolder: SurfaceHolder
    private lateinit var mGameThread: Thread

    private var mViewWidth: Int = 0
    private var mViewHeight: Int = 0

    private var touchX: Float = 0f
    private var touchY: Float = 0f

    private var mRunning = false

    private lateinit var application: Application

    constructor(context: Context) : super(context) {
        init(context, null, 0)
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init(context, attrs, 0)
    }

    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(
        context,
        attrs,
        defStyle
    ) {
        init(context, attrs, defStyle)
    }

    private fun init(context: Context, attrs: AttributeSet?, defStyle: Int) {
        mContext = context
        mSurfaceHolder = holder
    }

    fun setApplication(application: Application) {
        this.application = application
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        mViewWidth = w
        mViewHeight = h
    }

    override fun run() {
        var canvas: Canvas
        while (mRunning) {
            if (mSurfaceHolder.surface.isValid) {
                val program = application.program
                canvas = mSurfaceHolder.lockCanvas()
                canvas.save()
                program.draw(canvas)
                canvas.restore()
                mSurfaceHolder.unlockCanvasAndPost(canvas)
            }
        }
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        touchX = event.x
        touchY = event.y
        return true
    }

    fun pause() {
        mRunning = false
        try {
            mGameThread.join()
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }
    }

    fun resume() {
        mRunning = true
        mGameThread = Thread(this)
        mGameThread.start()
    }

}