package com.hongenit.gles.shapes;

import android.opengl.GLES20;
import android.opengl.GLSurfaceView;

/**
 * Created by Xiaohong on 2018/9/12.
 * desc: 形状的基类
 */
public abstract class BaseShape implements GLSurfaceView.Renderer{


    int loadShader(int type, String shaderCode) {
        // 创建着色器
        int shader = GLES20.glCreateShader(type);
        // 着色器链接代码
        GLES20.glShaderSource(shader, shaderCode);
        // 编译着色器
        GLES20.glCompileShader(shader);

        return shader;
    }


}
