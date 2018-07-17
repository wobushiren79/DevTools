package com.applecoffee.devtools.utils;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
public class BitmapUtils {

    /**
     * 怀旧效果
     *
     * @param src
     * @return
     */
    public static Bitmap createOldStyle(Bitmap src) {
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.set(new float[]{
                (float) 0.393, (float) 0.768, (float) 0.189, 0, 0,
                (float) 0.349, (float) 0.686, (float) 0.168, 0, 0,
                (float) 0.272, (float) 0.534, (float) 0.131, 0, 0,
                0, 0, 0, 1, 0
        });
        return baseBitmapHandler(src, colorMatrix);
    }

    /**
     * 灰度效果
     *
     * @param src
     * @return
     */
    public static Bitmap createGrayStyle(Bitmap src) {
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.set(new float[]{
                0.33f, 0.59f, 0.11f, 0, 0,
                0.33f, 0.59f, 0.11f, 0, 0,
                0.33f, 0.59f, 0.11f, 0, 0,
                0, 0, 0, 1, 0
        });
        return baseBitmapHandler(src, colorMatrix);
    }

    /**
     * 反转效果
     *
     * @param src
     * @return
     */
    public static Bitmap createReverseStyle(Bitmap src) {
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.set(new float[]{
                -1, 0, 0, 1, 1,
                0, -1, 0, 1, 1,
                0, 0, -1, 1, 1,
                0, 0, 0, 1, 0
        });
        return baseBitmapHandler(src, colorMatrix);
    }

    /**
     * 去色效果
     *
     * @param src
     * @return
     */
    public static Bitmap createClearColorStyle(Bitmap src) {
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.set(new float[]{
                1.5f, 1.5f, 1.5f, 0, -1,
                1.5f, 1.5f, 1.5f, 0, -1,
                1.5f, 1.5f, 1.5f, 0, -1,
                0, 0, 0, 1, 0
        });
        return baseBitmapHandler(src, colorMatrix);
    }

    /**
     * 光照效果
     *
     * @param src
     * @param lightStrength 0-2
     * @return
     */
    public static Bitmap createLightStyle(Bitmap src, float lightStrength) {
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.setScale(lightStrength, lightStrength, lightStrength, 1);
        return baseBitmapHandler(src, colorMatrix);
    }

    /**
     * 饱和度效果
     *
     * @param src
     * @param saturation 0-2
     * @return
     */
    public static Bitmap createSaturationStyle(Bitmap src, float saturation) {
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.setSaturation(saturation);
        return baseBitmapHandler(src, colorMatrix);
    }

    /**
     * 色调调整
     * @param src
     * @param redValueOffset
     * @param greenValueOffset
     * @param blueValueOffset
     * @return
     */
    public static Bitmap createRotateStyle(Bitmap src, float redValueOffset,float greenValueOffset,float blueValueOffset) {
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.setRotate(0, redValueOffset);
        colorMatrix.setRotate(1, greenValueOffset);
        colorMatrix.setRotate(2, blueValueOffset);
        return baseBitmapHandler(src, colorMatrix);
    }

    /**
     * 光照效果
     *
     * @param src
     * @param lightStrength
     * @return
     */
    public static Bitmap createLightStyleByPix(Bitmap src, float lightStrength) {
        /*
         * 算法原理：(前一个像素点RGB-当前像素点RGB+127)作为当前像素点RGB值
         * 在ABC中计算B点浮雕效果(RGB值在0~255)
         * B.r = C.r - B.r + 127
         * B.g = C.g - B.g + 127
         * B.b = C.b - B.b + 127
         * 光照中心取长宽较小值为半径,也可以自定义从左上角射过来
         */
        int width = src.getWidth();
        int height = src.getHeight();
        Bitmap bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.RGB_565);
        int pixColor = 0;
        int pixR = 0;
        int pixG = 0;
        int pixB = 0;
        int newR = 0;
        int newG = 0;
        int newB = 0;
        //围绕圆形光照
        int centerX = width / 2;
        int centerY = height / 2;
        int radius = Math.min(centerX, centerY);
        float strength = lightStrength;  //光照强度100-150
        int[] pixels = new int[width * height];
        src.getPixels(pixels, 0, width, 0, 0, width, height);
        for (int i = 1; i < height - 1; i++) {
            for (int k = 1; k < width - 1; k++) {
                //获取前一个像素颜色
                pixColor = pixels[width * i + k];
                pixR = Color.red(pixColor);
                pixG = Color.green(pixColor);
                pixB = Color.blue(pixColor);
                newR = pixR;
                newG = pixG;
                newB = pixB;
                //计算当前点到光照中心的距离,平面坐标系中两点之间的距离
                int distance = (int) (Math.pow((centerY - i), 2) + Math.pow((centerX - k), 2));
                if (distance < radius * radius) {
                    //按照距离大小计算增强的光照值
                    int result = (int) (strength * (1.0 - Math.sqrt(distance) / radius));
                    newR = pixR + result;
                    newG = newG + result;
                    newB = pixB + result;
                }
                newR = Math.min(255, Math.max(0, newR));
                newG = Math.min(255, Math.max(0, newG));
                newB = Math.min(255, Math.max(0, newB));
                pixels[width * i + k] = Color.argb(255, newR, newG, newB);
            }
        }
        bitmap.setPixels(pixels, 0, width, 0, 0, width, height);
        return bitmap;
    }


    /**
     * 基础处理
     *
     * @param src
     * @param colorMatrix
     * @return
     */
    public static Bitmap baseBitmapHandler(Bitmap src, ColorMatrix colorMatrix) {
        int width = src.getWidth();
        int height = src.getHeight();
        Bitmap bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Paint paint = new Paint();
        paint.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
        Canvas canvas = new Canvas(bitmap);
        canvas.drawBitmap(src, 0, 0, paint);
        return bitmap;
    }

}
