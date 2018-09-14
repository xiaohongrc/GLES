package com.hongenit.gles.image;

import android.content.res.Resources;
import android.opengl.GLES20;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by hongenit on 18/1/26.
 */

class ShaderUtil {

    private static final String TAG = "ShaderUtil";

    // 根据顶点着色器和片元着色器的代码文件 创建gl程序
    public static int createProgramByGLSLFile(Resources resources, String mVertex, String mFragment) {
        return createProgram(loadFileAssets(resources, mVertex), loadFileAssets(resources, mFragment));
    }

    public static int createProgram(String mVertex, String mFragment) {
        //        准备顶点着色器
        int vertexShader = loadShader(GLES20.GL_VERTEX_SHADER, mVertex);
        if (0 == vertexShader) return 0;
        //        准备片元着色器
        int fragmentShader = loadShader(GLES20.GL_FRAGMENT_SHADER, mFragment);
        if (0 == fragmentShader) return 0;

        //        创建着色器程序，不成功则返回0
        int program = GLES20.glCreateProgram();
        if (program != 0) {
            //        附着着色器
            GLES20.glAttachShader(program, vertexShader);
            GLES20.glAttachShader(program, fragmentShader);

            //        链接程序
            GLES20.glLinkProgram(program);

            //        检查链接程序是否成功
            int[] linked = new int[1];
            GLES20.glGetProgramiv(program, GLES20.GL_LINK_STATUS, linked, 0);
            if (linked[0] != GLES20.GL_TRUE) {
                Log.e(TAG, "linked error" + GLES20.glGetProgramInfoLog(program));
                // 链接程序失败则删除这个程序
                GLES20.glDeleteProgram(program);
                program = 0;
            }
        }
        return program;
    }


    private static int loadShader(int shaderType, String shaderSource) {
        // 创建shader
        int shader = GLES20.glCreateShader(shaderType);
        if (0 != shader) {
            // 设置shader源
            GLES20.glShaderSource(shader, shaderSource);
            // 编译着色器
            GLES20.glCompileShader(shader);
            int[] compiled = new int[1];
            GLES20.glGetShaderiv(shader, GLES20.GL_COMPILE_STATUS, compiled, 0);
            if (compiled[0] == 0) {
                Log.e(TAG, "Could not compile shader:" + shaderType);
                Log.e(TAG, "GLES20 Error:" + GLES20.glGetShaderInfoLog(shader));
                GLES20.glDeleteShader(shader);
                shader = 0;
            }
        }
        return shader;

    }


    public static String loadFileAssets(Resources resources, String fileName) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            InputStream inputStream = resources.getAssets().open(fileName);
            byte[] buffer = new byte[1024];
            int count;
            while (-1 != (count = inputStream.read(buffer))) {
                stringBuilder.append(new String(buffer, 0, count));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return stringBuilder.toString().replaceAll("\\r\\n", "\n");
    }

}
