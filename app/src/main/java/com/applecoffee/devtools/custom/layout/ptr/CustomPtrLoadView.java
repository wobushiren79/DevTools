package com.applecoffee.devtools.custom.layout.ptr;

import android.content.Context;
import android.support.annotation.AttrRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

import com.applecoffee.devtools.base.layout.BaseFrameLayout;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import in.srain.cube.views.ptr.PtrFrameLayout;
import in.srain.cube.views.ptr.PtrUIHandler;
import in.srain.cube.views.ptr.indicator.PtrIndicator;

public abstract class CustomPtrLoadView extends BaseFrameLayout implements PtrUIHandler {
    @Retention(RetentionPolicy.SOURCE)
    public @interface LoadType {
        //头部          //脚部
        int HEADER = 1, FOOT = 2;
    }

    private View mLoadView;

    //加载条的类型
    private @LoadType
    int mLoadType;


    public void setLoadType(@LoadType int loadType, View view) {
        mLoadView = view;
        mLoadType = loadType;
    }

    public CustomPtrLoadView(Context context) {
        super(context);
    }

    public CustomPtrLoadView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomPtrLoadView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

}
