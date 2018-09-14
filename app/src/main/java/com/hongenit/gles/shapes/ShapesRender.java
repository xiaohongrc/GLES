package com.hongenit.gles.shapes;

import android.opengl.GLES20;
import android.opengl.GLSurfaceView;

import com.hongenit.gles.util.LogUtils;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/**
 * Created by Xiaohong on 2018/9/14.
 * desc:
 */
public class ShapesRender implements GLSurfaceView.Renderer {
    private BaseShape mShape = new Cube();
    private EGLConfig mConfig;
    private GL10 mGl;
    private int mHeight;
    private int mWidth;

    @Override
    public void onSurfaceCreated(GL10 gl, EGLConfig config) {
        GLES20.glClearColor(0.5f, 0.5f, 0.5f, 1.0f);
        /**
         *  Note that when the EGL context is lost, all OpenGL resources associated
         * with that context will be automatically deleted. You do not need to call
         * the corresponding "glDelete" methods such as glDeleteTextures to
         * manually delete these lost resources.
         */
        // surface创建也代表EGL Context创建成功，所以所有该EGL Context下的opengl资源都会自动删除。所以在此处需重新创建，
        // 比如创建程序（glCreateProgram）或者创建着色器（glCreateShader）。
        setShape(mShape);
        LogUtils.d(this, "onSurfaceCreated");
        mGl = gl;
        mConfig = config;
        mShape.onSurfaceCreated(gl, config);
    }

    @Override
    public void onSurfaceChanged(GL10 gl, int width, int height) {
        GLES20.glViewport(0, 0, width, height);
        mWidth = width;
        mHeight = height;

        LogUtils.d(this, "onSurfaceChanged");
        mShape.onSurfaceChanged(gl, width, height);
    }

    @Override
    public void onDrawFrame(GL10 gl) {
        LogUtils.d(this, "onDrawFrame");
        mShape.onDrawFrame(gl);
    }

    public void setShape(BaseShape shape) {
        LogUtils.d(this, "setShape");
        mShape = shape;
        mShape.onSurfaceCreated(mGl, mConfig);
        mShape.onSurfaceChanged(mGl, mWidth, mHeight);
    }


}
