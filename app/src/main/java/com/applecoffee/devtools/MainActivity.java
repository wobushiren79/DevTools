package com.applecoffee.devtools;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.applecoffee.devtools.base.adapter.BaseRCAdapter;
import com.applecoffee.devtools.base.adapter.BaseViewHolder;
import com.applecoffee.devtools.custom.layout.ptr.CustomPtrLoadView;
import com.applecoffee.devtools.custom.layout.ptr.PtrRecyclerView;

import java.util.ArrayList;
import java.util.List;

import in.srain.cube.views.ptr.PtrDefaultHandler2;
import in.srain.cube.views.ptr.PtrFrameLayout;
import in.srain.cube.views.ptr.indicator.PtrIndicator;

public class MainActivity extends AppCompatActivity {

    ImageView nodata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nodata = new ImageView(this);
        nodata.setImageResource(R.mipmap.ic_launcher);
        final PtrRecyclerView ptrRecyclerView = findViewById(R.id.test_view);
        ptrRecyclerView.setPtrHandle2(new PtrDefaultHandler2() {
            @Override
            public void onLoadMoreBegin(PtrFrameLayout frame) {

            }

            @Override
            public void onRefreshBegin(PtrFrameLayout frame) {
                ptrRecyclerView.setRefreshComplete();
            }
        });
        BaseRCAdapter adapter = new BaseRCAdapter<String>(MainActivity.this, R.layout.layout_test) {
            @Override
            public void convert(BaseViewHolder holder, String o, int index) {
                TextView textView = holder.getView(R.id.tv_test);
                textView.setText(o);
            }

        };
        List<String> listData = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            listData.add(i + "test");
        }
        adapter.setData(listData);

        CustomPtrLoadView headLayout = new CustomPtrLoadView(this) {
            @Override
            public void initView() {

            }

            @Override
            public void initData() {

            }

            @Override
            protected int setLayoutId() {
                return R.layout.layout_test;
            }

            @Override
            public void onUIReset(PtrFrameLayout frame) {

            }

            @Override
            public void onUIRefreshPrepare(PtrFrameLayout frame) {

            }

            @Override
            public void onUIRefreshBegin(PtrFrameLayout frame) {

            }

            @Override
            public void onUIRefreshComplete(PtrFrameLayout frame, boolean isHeader) {

            }

            @Override
            public void onUIPositionChange(PtrFrameLayout frame, boolean isUnderTouch, byte status, PtrIndicator ptrIndicator) {

            }
        };
        headLayout.setLoadType(CustomPtrLoadView.LoadType.HEADER, headLayout);

        ptrRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        ptrRecyclerView.setAdapter(adapter);
        ptrRecyclerView.setNoDataLayout(nodata);
        ptrRecyclerView.setHeadLoadLayout(headLayout);
    }
}
