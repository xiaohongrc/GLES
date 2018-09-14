package com.hongenit.gles.surface

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View

/**
 * Created by hongenit on 18/1/25.
 * 在自定义中画图，主线程，和surfaceview画图作对比。
 */
class DrawView(context: Context, attributes: AttributeSet, defStyleAttr: Int) : View(context, attributes, defStyleAttr) {

    constructor(context: Context, attributes: AttributeSet) : this(context, attributes, 0)

    private var mArcRect: RectF = RectF()
    private var mPaint: Paint = Paint()

    init {

        mPaint.style = Paint.Style.STROKE
        mPaint.color = Color.BLUE
        mPaint.strokeWidth = 4f
        mPaint.strokeCap = Paint.Cap.ROUND
    }


    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        drawing(canvas)

    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)

        println("on measure()$measuredHeight height = $height")


    }

    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        super.onLayout(changed, left, top, right, bottom)
        println("onLayout()$measuredHeight height= $height")
    }

    private var sweepAngle = 0f
    private var startAngle = 0f
    private var lastTime = 0
    var time = 0

    val STEP_RADIUS = 8

    fun drawing(canvas: Canvas?) {

        val centralX = width / 2f
        val centralY = height / 2f
        println("ondraw()$measuredHeight height= $height")
        var arcRadius = Math.min(centralX, centralY) * 4 / 5
        System.out.println("sweepAngle  = " + sweepAngle)
        startAngle += 10
        time = (startAngle / 360).toInt()
        if (lastTime != time) {
            lastTime = time
            arcRadius -= STEP_RADIUS
            mArcRect.left = centralX - arcRadius
            mArcRect.top = centralY - arcRadius
            mArcRect.right = centralX + arcRadius
            mArcRect.bottom = centralY + arcRadius
        }
        canvas?.drawArc(mArcRect, startAngle, sweepAngle, false, mPaint)
//        invalidate()
        postInvalidateDelayed(5000)
    }


}