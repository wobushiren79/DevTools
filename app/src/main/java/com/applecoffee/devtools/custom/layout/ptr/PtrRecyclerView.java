package com.applecoffee.devtools.custom.layout.ptr;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.applecoffee.devtools.R;
import com.applecoffee.devtools.base.layout.BaseLinearLayout;

import in.srain.cube.views.ptr.PtrDefaultHandler2;


public class PtrRecyclerView extends BaseLinearLayout {
    private RecyclerView mPtrRecyclerView;
    private RelativeLayout mPtrRLLayout;
    private CustomPtrFramelayout mPtrFrameLayout;

    //没有数据的布局
    private View mNoDataLayout;

    public PtrRecyclerView(Context context) {
        super(context);
    }

    public PtrRecyclerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void initView() {
        mPtrRecyclerView = getView(R.id.ptr_recycler_view);
        mPtrRLLayout = getView(R.id.ptr_rl_layout);
        mPtrFrameLayout = getView(R.id.ptr_custom_layout);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected int setLayoutId() {
        return R.layout.layout_ptr_recycler_view;
    }

    /**
     * 设置没有数据时的显示
     *
     * @param noDataLayout
     */
    public void setNoDataLayout(View noDataLayout) {
        mNoDataLayout = noDataLayout;
        mPtrRLLayout.addView(noDataLayout, 0);
    }

    /**
     * 设置没数据时的是否显示
     *
     * @param visibility
     */
    public void setHasDataVisibility(int visibility) {
        if (mNoDataLayout != null)
            mNoDataLayout.setVisibility(visibility);
    }

    /**
     * 设置下拉刷新监听
     */
    public void setPtrHandle2(PtrDefaultHandler2 ptrHandler) {
        mPtrFrameLayout.setPtrHandler(ptrHandler);
    }

    /**
     * 设置刷新数据
     */
    public void setRefresh() {
        mPtrFrameLayout.autoRefresh();
    }

    /**
     * 设置刷新完成
     */
    public void setRefreshComplete() {
        mPtrFrameLayout.refreshComplete();
    }

    /**
     * 设置recycler的布局样式
     *
     * @param layoutManager
     */
    public void setLayoutManager(RecyclerView.LayoutManager layoutManager) {
        mPtrRecyclerView.setLayoutManager(layoutManager);
    }

    /**
     * 设置recycler的适配
     *
     * @param adapter
     */
    public void setAdapter(RecyclerView.Adapter adapter) {
        mPtrRecyclerView.setAdapter(adapter);
    }

    /**
     * 设置头部刷新样式
     * @param headerLayout
     */
    public void setHeadLoadLayout(CustomPtrLoadView headerLayout) {
        mPtrFrameLayout.setHeader(headerLayout);
    }

    /**
     * 设置脚部刷新样式
     * @param footLayout
     */
    public void setFootLoadLayout(CustomPtrLoadView footLayout) {
        mPtrFrameLayout.setFooter(footLayout);
    }
}
