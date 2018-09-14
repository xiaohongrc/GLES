package com.hongenit.gles.surface;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * Created by hongenit on 18/1/25.
 * 使用surfaceview画图。
 */

public class DrawSurfaceView extends SurfaceView implements SurfaceHolder.Callback {
    private Canvas mCanvas;
    private RectF mArcRect;
    private Paint mPaint;
    private boolean isDrawing = false;

    public DrawSurfaceView(Context context) {

        this(context, null);
    }

    public DrawSurfaceView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public DrawSurfaceView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        System.out.println("init");
        SurfaceHolder holder = getHolder();
        holder.addCallback(this);
        mArcRect = new RectF();
        mPaint = new Paint();
        mPaint.setColor(Color.RED);
        mPaint.setStrokeWidth(4);
        mPaint.setStrokeCap(Paint.Cap.ROUND);
        mPaint.setStyle(Paint.Style.STROKE);
    }


    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        isDrawing = true;
        drawSomething(holder);

    }

    // 开启一个线程去画
    private void drawSomething(final SurfaceHolder holder) {


        new Thread(new Runnable() {
            public static final int STEP_RADIUS = 10;
            float sweepAngle = 10;
            float startAngle = 0;
            int lastTime = 0;
            int centralX = getWidth() / 2;
            int centralY = getHeight() / 2;
            int arcRadius = Math.min(centralX, centralY) * 4 / 5;

            @Override
            public void run() {
                mArcRect.left = centralX - arcRadius;
                mArcRect.top = centralY - arcRadius;
                mArcRect.right = centralX + arcRadius;
                mArcRect.bottom = centralY + arcRadius;

                System.out.println(mArcRect);
                while (isDrawing) {
//                    SystemClock.sleep(50);
                    drawing();

                }
            }


            void drawing() {

                try {
                    mCanvas = holder.lockCanvas();
                    if (mCanvas != null) {

                        System.out.println("sweepAngle  = " + sweepAngle);

                        startAngle += 10;
//                            sweepAngle += 2;
                        int time = (int) (startAngle / 360);
                        if (lastTime != time) {
                            lastTime = time;
                            arcRadius -= STEP_RADIUS;
                            mArcRect.left = centralX - arcRadius;
                            mArcRect.top = centralY - arcRadius;
                            mArcRect.right = centralX + arcRadius;
                            mArcRect.bottom = centralY + arcRadius;
                        }

                        mCanvas.drawArc(mArcRect, startAngle, sweepAngle, false, mPaint);

                    }
                } finally {
                    if (mCanvas != null) {
                        holder.unlockCanvasAndPost(mCanvas);
                    }
                }
            }
        }).start();
    }


    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        isDrawing = false;
//        holder.unlockCanvasAndPost(mCanvas);

    }


}
