package com.applecoffee.devtools.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by zm.
 */

public class ToastUtils {

    /**
     * Toase  短时间
     * @param context
     * @param message
     */
    public static void showToastShort(Context context, String message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }

    /**
     * Toast 长时间
     * @param context
     * @param message
     */
    public static void showToastLong(Context context, String message) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show();
    }
}
