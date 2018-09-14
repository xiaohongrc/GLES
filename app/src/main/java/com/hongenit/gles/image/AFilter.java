package com.hongenit.gles.image;

import android.content.Context;
import android.graphics.Shader;
import android.opengl.GLSurfaceView;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/**
 * Created by hongenit on 18/1/26.
 * filter
 */

public class AFilter implements GLSurfaceView.Renderer {

    private final Context mContext;
    private String mVertex;
    private String mFragment;

    public AFilter(Context context, String vertex, String fragment) {
        mContext = context;
        mVertex = vertex;
        mFragment = fragment;

    }

    @Override
    public void onSurfaceCreated(GL10 gl, EGLConfig config) {

        // 根据顶点着色器和片元着色器的文件准备好链接了着色器的程序。
        int program = ShaderUtil.createProgramByGLSLFile(mContext.getResources(), mVertex, mFragment);


    }

    @Override
    public void onSurfaceChanged(GL10 gl, int width, int height) {

    }

    @Override
    public void onDrawFrame(GL10 gl) {
//        可以通过 GLSurfaceView 的 setRenderMode 这个方法来设置是通过其它地方的消息来刷新 onDrawFrame，抑或让系统自动刷新 onDrawFrame 这个函数。
//        如果setRenderMode（）的参数为 RENDERMODE_CONTINUOUSLY, 系统会连续的每隔16毫秒调用 onDrawFrame（） 函数。

    }


}
