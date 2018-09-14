package com.hongenit.gles.shapes;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;

import com.hongenit.gles.util.LogUtils;

/**
 * Created by Xiaohong on 2018/9/11.
 * desc:
 */
public class ShapeGlView extends GLSurfaceView {
    private final int GLES_VERSION = 2;
    private ShapesRender mRender;

    public ShapeGlView(Context context) {
        super(context);
        init();
    }


    public ShapeGlView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        LogUtils.d(this, "init() ");
        // 设置opengl Es 版本， 2代表OpenGL ES 2.0
        setEGLContextClientVersion(GLES_VERSION);
        mRender = new ShapesRender();
        setRenderer(mRender);
        // 设置渲染方式
        setRenderMode(GLSurfaceView.RENDERMODE_WHEN_DIRTY);
    }

    public void setShape(final BaseShape shape) {
        LogUtils.d(this, "setShape() ");
        // 要调用openGl的方法重新绘制一个形状，必须在openGl线程（即GlSurfaceView.Render线程）。否则会报错或调用方法失败。E/libEGL: call to OpenGL ES API with no current context (logged once per thread)
        queueEvent(new Runnable() {
            @Override
            public void run() {
                mRender.setShape(shape);
            }
        });
        requestRender();
    }

}
