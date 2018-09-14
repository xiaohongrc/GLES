package com.hongenit.gles;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hongenit.gles.image.SGLViewActivity;
import com.hongenit.gles.shapes.DrawShapeActivity;
import com.hongenit.gles.surface.DrawSurfaceActivity;

import java.util.ArrayList;

/**
 * Created by hongenit on 18/1/23.
 * show all function list
 */

public class MainActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        RecyclerView rv = findViewById(R.id.rv_entries);
        rv.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        rv.setAdapter(new MainAdapter(this));
    }

    private ArrayList<EntryBean> entries = new ArrayList<>();

    void initData() {
        entries.add(new EntryBean("图片处理", SGLViewActivity.class));
        entries.add(new EntryBean("Surface画图", DrawSurfaceActivity.class));
        entries.add(new EntryBean("Surface画图", DrawShapeActivity.class));


    }


    class MainAdapter extends RecyclerView.Adapter implements View.OnClickListener {
        private Context mContext = null;

        public MainAdapter(Context context) {
            mContext = context;
        }

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(mContext).inflate(R.layout.item_entry, parent, false);

            view.setOnClickListener(this);
            MainHolder mainHolder = new MainHolder(view);


            return mainHolder;
        }


        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            MainHolder mainHolder = null;
            if (holder instanceof MainHolder) {
                mainHolder = (MainHolder) holder;
                mainHolder.tvEntryName.setText(entries.get(position).getName());
            }
            holder.itemView.setTag(position);


        }

        @Override
        public int getItemCount() {
            return entries.size();
        }


        @Override
        public void onClick(View v) {
            int pos = (int) v.getTag();
            Intent intent = new Intent();
            intent.setClass(mContext, entries.get(pos).getData());
            startActivity(intent);

        }
    }

    class MainHolder extends RecyclerView.ViewHolder {


        private final TextView tvEntryName;

        public MainHolder(View itemView) {
            super(itemView);
            tvEntryName = itemView.findViewById(R.id.tv_entry_name);
        }
    }


}
