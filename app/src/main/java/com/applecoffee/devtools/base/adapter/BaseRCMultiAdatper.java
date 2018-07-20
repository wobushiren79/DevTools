package com.applecoffee.devtools.base.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class BaseRCMultiAdatper<T> extends RecyclerView.Adapter<BaseViewHolder> implements IBaseRCAdapter<T> {
    protected List<T> mDatas = new ArrayList<>();
    protected Context mContext;
    protected Map<Integer, Integer> mLayoutMap = new HashMap<>();

    /**
     * 初始化
     *
     * @param context
     */
    public BaseRCMultiAdatper(Context context) {
        mContext = context;
        mLayoutMap = setLayoutMap();
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        BaseViewHolder viewHolder = BaseViewHolder.get(mContext, parent, mLayoutMap.get(viewType));
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        convert(holder, mDatas.get(position), position, getItemViewType(position));
    }

    @Override
    public int getItemViewType(int position) {
        return setItemType(position);
    }

    /**
     * 获取上下文对象
     *
     * @return
     */
    public Context getContext() {
        return mContext;
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    @Override
    public List setData(List mDatas) {
        this.mDatas = mDatas;
        this.notifyDataSetChanged();
        return this.mDatas;
    }

    @Override
    public List setData(T[] mDatas) {
        this.mDatas = Arrays.asList(mDatas);
        this.notifyDataSetChanged();
        return this.mDatas;
    }

    @Override
    public List addData(List mDatas) {
        this.mDatas.addAll(mDatas);
        this.notifyDataSetChanged();
        return this.mDatas;
    }

    @Override
    public List addData(T[] mDatas) {
        this.mDatas.addAll(Arrays.asList(mDatas));
        this.notifyDataSetChanged();
        return this.mDatas;
    }

    @Override
    public List removeData(List mDatas) {
        this.mDatas.removeAll(mDatas);
        this.notifyDataSetChanged();
        return this.mDatas;
    }

    @Override
    public List removeData(T[] mDatas) {
        this.mDatas.removeAll(Arrays.asList(mDatas));
        this.notifyDataSetChanged();
        return this.mDatas;
    }

    public List<T> getData() {
        return mDatas;
    }

    public abstract void convert(BaseViewHolder holder, T t, int index, int itemType);

    /**
     * 设置布局
     *
     * @return
     */
    public abstract Map<Integer, Integer> setLayoutMap();

    /**
     * 设置多item判断条件
     *
     * @param position
     * @return
     */
    public abstract int setItemType(int position);
}
