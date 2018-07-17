package com.applecoffee.devtools;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.applecoffee.devtools.utils.BitmapUtils;

public class MainActivity extends AppCompatActivity {


    private ImageView mIVTest;
    private ImageView mIVTest2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
}
