package com.wzhy.myana.general.utils;

/**
 * 用于px与dp、sp之间转换
 * Created by wangzhengyang on 2017/1/20.
 */

public class DisplayUtil implements Util{
    /**
     * dp转px
     */
    public static int dp2px(int dpValue) {
        return ((int) (dp2pxF(dpValue) + 0.5));
    }

    /**
     * px转dp
     */
    public static int px2dp(int pxValue) {
        return ((int) (px2dpF(pxValue) + 0.5));
    }

    /**
     * sp转px
     */
    public static int sp2px(int spValue) {
        return ((int) (sp2pxF(spValue) + 0.5));
    }

    /**
     * px转sp
     */
    public static int px2sp(int pxValue) {
        return ((int) (px2spF(pxValue) + 0.5));
    }

//**//**//**//**//**//**//**//**//**//**//**//**//**//**//**//**//**//**//**//**//**//**//**//**//

    /**
     * dp转px
     */
    public static float dp2pxF(float dpValue) {
        float density = RES.getDisplayMetrics().density;
        return dpValue * density;
    }

    /**
     * px转dp
     */
    public static float px2dpF(float pxValue) {
        float density = RES.getDisplayMetrics().density;
        return pxValue / density;
    }

    /**
     * sp转px
     */
    public static float sp2pxF(float spValue) {
        float fontScale = RES.getDisplayMetrics().scaledDensity;
        return spValue * fontScale;
    }

    /**
     * px转sp
     */
    public static float px2spF(float pxValue) {
        float fontScale = RES.getDisplayMetrics().scaledDensity;
        return pxValue / fontScale;
    }

}
