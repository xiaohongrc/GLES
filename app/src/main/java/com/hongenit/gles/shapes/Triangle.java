package com.hongenit.gles.shapes;

import android.opengl.GLES20;

import com.hongenit.gles.util.LogUtils;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/**
 * Created by Xiaohong on 2018/9/13.
 * desc:
 */
public class Triangle extends BaseShape {
    private final String vertexShaderCode =
            "attribute vec4 vPosition;" +
                    "void main() {" +
                    "  gl_Position = vPosition;" +
                    "}";

    private final String fragmentShaderCode =
            "precision mediump float;" +
                    "uniform vec4 vColor;" +
                    "void main() {" +
                    "  gl_FragColor = vColor;" +
                    "}";
    private int program;

    // 每个顶点属性的组件数量。例如：顶点由（x,y,z）三个组件构成，颜色值（rgba）则为4。
    static final int COORDS_PER_VERTEX = 3;
    //顶点个数
    private final int vertexCount = triangleCoords.length / COORDS_PER_VERTEX;
    //顶点之间的偏移量
    private final int vertexStride = COORDS_PER_VERTEX * 4; // 每个顶点四个字节

    private static float triangleCoords[] = {
            0.5f, 0.5f, 0.0f, // top
            -0.5f, -0.5f, 0.0f, // bottom left
            0.5f, -0.5f, 0.0f  // bottom right
    };

    private int mPositionHandle;
    private int mColorHandle;
    private FloatBuffer vertexBuffer;
    //设置颜色，依次为红绿蓝和透明通道
    float color[] = {1.0f, 0f, 0f, 1.0f};

    public Triangle() {

    }

    void createProgram() {

        // 申请内存存储顶点数组
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(triangleCoords.length * 4);
        byteBuffer.order(ByteOrder.nativeOrder());
        // ByteBuffer转FloatBuffer
        vertexBuffer = byteBuffer.asFloatBuffer();
        vertexBuffer.put(triangleCoords);
        vertexBuffer.position(0);
        program = GLES20.glCreateProgram();
        // 附着顶点着色器到程序
        GLES20.glAttachShader(program, loadShader(GLES20.GL_VERTEX_SHADER, vertexShaderCode));
        // 附着片元着色器到程序
        GLES20.glAttachShader(program, loadShader(GLES20.GL_FRAGMENT_SHADER, fragmentShaderCode));
        // 链接程序
        GLES20.glLinkProgram(program);

        int[] glLinkStatus = new int[1];
        // 获取程序链接的状态
        GLES20.glGetProgramiv(program, GLES20.GL_LINK_STATUS, glLinkStatus, 0);

        // 创建程序（glCreateProgram）或者创建着色器（glCreateShader）必须在Render的onSurfaceCreated方法之后执行，否则创建不成功返回0.
        if (glLinkStatus[0] != GLES20.GL_TRUE) {
            GLES20.glDeleteProgram(program);
            program = 0;
            LogUtils.hong("program = 0");
        }


    }


    @Override
    public void onSurfaceCreated(GL10 gl, EGLConfig config) {
        LogUtils.d(this, "onSurfaceCreated");

        /**
         *  Note that when the EGL context is lost, all OpenGL resources associated
         * with that context will be automatically deleted. You do not need to call
         * the corresponding "glDelete" methods such as glDeleteTextures to
         * manually delete these lost resources.
         */
        // surface创建也代表EGL Context创建成功，所以所有该EGL Context下的opengl资源都会自动删除。所以在此处需重新创建，
        // 比如创建程序（glCreateProgram）或者创建着色器（glCreateShader）。
        createProgram();
    }

    @Override
    public void onSurfaceChanged(GL10 gl, int width, int height) {
        LogUtils.d(this, "onSurfaceChanged");
    }

    @Override
    public void onDrawFrame(GL10 gl) {
        GLES20.glClear(GLES20.GL_COLOR_BUFFER_BIT | GLES20.GL_DEPTH_BUFFER_BIT);
        LogUtils.hong("Triangle------------ = ");
        LogUtils.d(this, "onDrawFrame");
        // 使用GL程序
        GLES20.glUseProgram(program);

        //获取顶点着色器的vPosition成员句柄
        mPositionHandle = GLES20.glGetAttribLocation(program, "vPosition");
        //启用三角形顶点的句柄
        GLES20.glEnableVertexAttribArray(mPositionHandle);
        //准备三角形的坐标数据
        GLES20.glVertexAttribPointer(mPositionHandle, COORDS_PER_VERTEX, GLES20.GL_FLOAT, false, vertexStride, vertexBuffer);

        //获取片元着色器的vColor成员的句柄
        mColorHandle = GLES20.glGetUniformLocation(program, "vColor");
        //设置绘制三角形的颜色
        GLES20.glUniform4fv(mColorHandle, 1, color, 0);
        //绘制三角形
        GLES20.glDrawArrays(GLES20.GL_TRIANGLES, 0, vertexCount);
        GLES20.glDisableVertexAttribArray(mPositionHandle);


    }


}
