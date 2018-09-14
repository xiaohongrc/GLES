package com.hongenit.gles.shapes;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.hongenit.gles.R;

/**
 * Created by Xiaohong on 2018/9/11.
 * desc: 画各种图形的activity
 */
public class DrawShapeActivity extends AppCompatActivity implements View.OnClickListener {

    private ShapeGlView gl_shape_view;
    private Button btn_switch_shape;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_draw_shape);
        initView();

    }

    private void initView() {
        gl_shape_view = findViewById(R.id.gl_shape_view);
        btn_switch_shape = findViewById(R.id.btn_switch_shape);
        btn_switch_shape.setOnClickListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.pop_shapes_item, menu);
        return super.onCreateOptionsMenu(menu);
    }

//    @Override
//    public boolean onMenuItemSelected(int featureId, MenuItem item) {
//
//
//
//        return super.onMenuItemSelected(featureId, item);
//    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.mTriangle:
                gl_shape_view.setShape(new Triangle());
                break;
            case R.id.mTriangleWithCamera:
                gl_shape_view.setShape(new TriangleWithCamera(gl_shape_view));
                break;
            case R.id.mTriangleColorFull:
                gl_shape_view.setShape(new TriangleColorFull(gl_shape_view));
                break;
            case R.id.mSquare:
                gl_shape_view.setShape(new Square(gl_shape_view));
                break;
            case R.id.mOval:
                gl_shape_view.setShape(new Oval());
                break;
            case R.id.mCube:
                gl_shape_view.setShape(new Cube());
                break;
            case R.id.mCone:
                gl_shape_view.setShape(new Cone(gl_shape_view));
                break;

            case R.id.mCylinder:
                gl_shape_view.setShape(new Cylinder(gl_shape_view));
                break;

            case R.id.mBall:
                gl_shape_view.setShape(new Ball(gl_shape_view));
                break;
            case R.id.mBallWithLight:
                gl_shape_view.setShape(new BallWithLight(gl_shape_view));
                break;

            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_switch_shape:
                // 展开形状选择列表
                gl_shape_view.setShape(new Triangle());


                break;
            default:
                break;
        }
    }


}
