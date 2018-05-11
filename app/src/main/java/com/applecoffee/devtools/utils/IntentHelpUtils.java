package com.applecoffee.devtools.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

public class IntentHelpUtils {
    /***
     * 跳转到视频文件选择器
     * @param activity
     * @param requestCode
     */
    public static void IntentToVideoSelect(Activity activity, int requestCode) {
        String action;
        if (SystemUtil.getDeviceBrand().contains("Meizu")) {
            action = Intent.ACTION_GET_CONTENT;
        } else {
            action = Intent.ACTION_PICK;
        }
        Intent intent = new Intent(action, android.provider.MediaStore.Video.Media.EXTERNAL_CONTENT_URI);
        activity.startActivityForResult(intent, requestCode);
    }
}
