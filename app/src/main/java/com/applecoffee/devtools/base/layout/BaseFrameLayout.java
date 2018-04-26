package com.applecoffee.devtools.base.layout;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;

public abstract class BaseFrameLayout extends FrameLayout {
    //布局控件
    protected View mLayoutView;

    public BaseFrameLayout(Context context) {
        this(context, null);
    }

    public BaseFrameLayout(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BaseFrameLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mLayoutView = LayoutInflater.from(context).inflate(setLayoutId(), null);
        addView(mLayoutView);
        initView();
        initData();
    }

    /**
     * 初始化控件
     */
    protected abstract void initView();

    /**
     * 初始化数据
     */
    protected abstract void initData();

    /**
     * 设置布局ID
     *
     * @return
     */
    protected abstract int setLayoutId();


    /**
     * 获取布局
     *
     * @return
     */
    public View getLayoutView() {
        return mLayoutView;
    }

    /**
     * 获取控件ID
     *
     * @param viewId
     * @return
     */
    protected <T extends View> T getView(int viewId) {
        return mLayoutView.findViewById(viewId);
    }
}
