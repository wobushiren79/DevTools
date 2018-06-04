package com.applecoffee.devtools.utils;

import android.content.Context;
import android.view.Gravity;
import android.widget.Toast;

/**
 * Created by zm.
 */

public class ToastUtils {

    /**
     * Toase  短时间
     *
     * @param context
     * @param message
     */
    public static void showToastShort(Context context, String message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }

    /**
     * Toast 长时间
     *
     * @param context
     * @param message
     */
    public static void showToastLong(Context context, String message) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show();
    }


    /**
     * Toase  短时间 居中
     *
     * @param context
     * @param text
     */
    public static void showToastShortInCenter(Context context, String text) {
        Toast toast = Toast.makeText(context, text, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }

    /**
     * Toast 长时间 居中
     *
     * @param context
     * @param text
     */
    public static void showToastLongInCenter(Context context, String text) {
        Toast toast = Toast.makeText(context, text, Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }
}
