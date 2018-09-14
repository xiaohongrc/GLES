package com.hongenit.gles.image;

import android.opengl.GLSurfaceView;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/**
 * Created by hongenit on 18/1/25.
 * renderer
 */

class SGLRenderer implements GLSurfaceView.Renderer {


    private AFilter mFilter;

    @Override
    public void onSurfaceCreated(GL10 gl, EGLConfig config) {
        mFilter.onSurfaceCreated(gl,config);


    }

    @Override
    public void onSurfaceChanged(GL10 gl, int width, int height) {
        mFilter.onSurfaceChanged(gl,width,height);

    }

    @Override
    public void onDrawFrame(GL10 gl) {
        mFilter.onDrawFrame(gl);

    }


    public void setFilter(AFilter filter) {
        mFilter = filter;

    }
}
