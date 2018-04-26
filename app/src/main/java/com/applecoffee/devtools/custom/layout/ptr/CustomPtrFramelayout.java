package com.applecoffee.devtools.custom.layout.ptr;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

import in.srain.cube.views.ptr.PtrFrameLayout;

public class CustomPtrFramelayout extends PtrFrameLayout {
    CustomPtrLoadView header;
    CustomPtrLoadView footer;

    public CustomPtrFramelayout(Context context) {
        this(context, null);
    }

    public CustomPtrFramelayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CustomPtrFramelayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public void setHeader(CustomPtrLoadView headerView) {
        header = headerView;
        setHeaderView(header);
        addPtrUIHandler(header);
    }

    public void setFooter(CustomPtrLoadView footerView) {
        footer = footerView;
        setFooterView(footer);
        addPtrUIHandler(footer);
    }

}
