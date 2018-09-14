package com.hongenit.gles.image;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;

/**
 * Created by hongenit on 18/1/24.
 * sglview
 */

public class SGLView extends GLSurfaceView {
    private  static final int GLES_VERSION = 2;
    private SGLRenderer sglRenderer;

    public SGLView(Context context) {
        super(context);
    }

    public SGLView(Context context, AttributeSet attrs) {
        super(context, attrs);

        init();
    }

    private void init() {

        // 设置opengl Es 版本， 2代表OpenGL ES 2.0
        setEGLContextClientVersion(GLES_VERSION);

//        设置glsurfaceView的渲染器
        setRenderer(sglRenderer = new SGLRenderer());

//        设置渲染方式
        setRenderMode(GLSurfaceView.RENDERMODE_WHEN_DIRTY);

    }


    public void setFilter(AFilter filter) {
        sglRenderer.setFilter(filter);

    }


}
