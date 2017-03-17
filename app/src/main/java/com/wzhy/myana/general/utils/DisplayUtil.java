package com.wzhy.myana.general.utils;

/**
 * 用于px与dp、sp之间转换
 * Created by wangzhengyang on 2017/1/20.
 */

public class DisplayUtil implements Util{

    public static int dp2px(int dpValue) {
        return ((int) (dp2pxF(dpValue) + 0.5));
    }
    public static int px2dp(int pxValue) {
        return ((int) (px2dpF(pxValue) + 0.5));
    }

    public static int sp2px(int spValue) {
        return ((int) (sp2pxF(spValue) + 0.5));
    }

    public static int px2sp(int pxValue) {
        return ((int) (px2spF(pxValue) + 0.5));
    }

    public static float dp2pxF(int dpValue) {
        float density = RES.getDisplayMetrics().density;
        return dpValue * density;
    }

    public static float px2dpF(int pxValue) {
        float density = RES.getDisplayMetrics().density;
        return pxValue / density;
    }

    public static float sp2pxF(int spValue) {
        float fontScale = RES.getDisplayMetrics().scaledDensity;
        return spValue * fontScale;
    }

    public static float px2spF(int pxValue) {
        float fontScale = RES.getDisplayMetrics().scaledDensity;
        return pxValue / fontScale;
    }

}
