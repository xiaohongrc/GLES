package com.hongenit.gles.image

import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import com.hongenit.gles.R

/**
 * Created by hongenit on 18/1/23.
 *
 */

class SGLViewActivity : AppCompatActivity(){

    private lateinit var sglView: SGLView

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.activity_image)
        sglView = findViewById(R.id.sglView)

    }

    override fun onResume() {
        super.onResume()
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_filter,menu)
        return super.onCreateOptionsMenu(menu)
    }


    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when(item?.itemId){
//            R.id.mDeal->sglView.setFilter(AFilter())
//                <item android:id="@+id/mDeal"
//                app:showAsAction="always"
//                android:title="全部处理" />
//                <item android:id="@+id/mDefault"
//                android:title="原图" />
//                <item android:id="@+id/mGray"
//                android:title="黑白" />
//                <item android:id="@+id/mCool"
//                android:title="冷色调" />
//                <item android:id="@+id/mWarm"
//                android:title="暖色调" />
//                <item android:id="@+id/mBlur"
//                android:title="模糊" />
//                <item android:id="@+id/mMagn"
//                android:title="放大镜" />
        }


        return super.onOptionsItemSelected(item)
    }




}
