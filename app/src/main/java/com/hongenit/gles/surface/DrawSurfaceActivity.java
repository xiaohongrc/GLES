package com.hongenit.gles.surface;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.hongenit.gles.R;

/**
 * Created by hongenit on 18/1/25.
 * surface draw view activity
 */

public class DrawSurfaceActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_draw_surface);

        initView();
    }

    private void initView() {
        findViewById(R.id.btn).setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        Toast.makeText(this,"chulailaiilai",Toast.LENGTH_LONG).show();
    }
}
