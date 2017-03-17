package com.wzhy.myana.general.utils;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.Shape;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.wzhy.myana.R;


/**
 * 吐司工具类
 * Created by wangzhengyang on 2017/1/19.
 */

public class ToastUtil implements Util {

    public static final int LAYOUT_TIP = R.layout.layout_tip;
    public static final int TEXT_VIEW_TIP = R.id.tip_text;
    public static final int IMG_VIWE_TIP = R.id.tip_img;
    public static final int GRAVITY_DEFAULT = Integer.MIN_VALUE;


    // 系统默认吐司 —》

    /**
     * 短吐司
     * @param pTip 要吐司的内容
     */
    public static void showTip(String pTip) {
        showTipDef(pTip, Toast.LENGTH_SHORT);
    }

    /**
     * 长吐司
     * @param pTip 要吐司的内容
     */
    public static void showLongTip(String pTip) {
        showTipDef(pTip, Toast.LENGTH_LONG);
    }

    private static void showTipDef(String pTip, int pDuration) {
        if (null == pTip) throw new NullPointerException("Text is null!");
        Toast.makeText(CONTEXT, pTip, pDuration).show();
    }

    // 《— 系统默认吐司

    // 显示自定义吐司 —》

    private static void showTipCus(int pDuration, int layoutId, ViewCallBack pViewCallBack, int pGravity) {
        Toast tip = new Toast(CONTEXT);
        tip.setDuration(pDuration);
        if (layoutId <= 0) layoutId = LAYOUT_TIP;
        View v = INFLATER.inflate(layoutId, null);
        v = pViewCallBack.getView(v);
        tip.setView(v);
        if (pGravity != GRAVITY_DEFAULT) {
            tip.setGravity(pGravity, 0, 0);
        }
        tip.show();
    }



    // 显示吐司 显示自定义默认吐司 —》

    private static void showTipCustom(final String pTip, int pDuration, final int pGravity){
        if (null == pTip) return;
        showTipCus(pDuration, LAYOUT_TIP, new ViewCallBack() {
            @Override
            public View getView(View v) {
                TextView tv = (TextView) v.findViewById(TEXT_VIEW_TIP);
                tv.setText(pTip);
                return v;
            }
        }, pGravity);
    }

    public static void showTipCus(String pTip) {
        showTipCustom(pTip, Toast.LENGTH_SHORT, GRAVITY_DEFAULT);
    }

    public static void showLongTipCus(String pTip) {
        showTipCustom(pTip, Toast.LENGTH_LONG, GRAVITY_DEFAULT);
    }

    public static void showTipCusCenter(final String pTip) {
        showTipCustom(pTip, Toast.LENGTH_SHORT, Gravity.CENTER);
    }

    public static void showLongTipCusCenter(final String pTip) {
        showTipCustom(pTip, Toast.LENGTH_LONG, Gravity.CENTER);
    }

    // 《— 显示吐司 显示自定义默认吐司

    // 显示吐司 可以设置背景颜色和文字颜色 —》

    private static void showTipCus(final String pTip, int pDuration, final int pGravity, final int bgColor, final int textColor){
        if (null == pTip) return;
        showTipCus(pDuration, LAYOUT_TIP, new ViewCallBack() {
            @Override
            public View getView(final View v) {
                if (bgColor > 0) {
                    ShapeDrawable shapeDrawable = new ShapeDrawable(new Shape() {
                        @Override
                        public void draw(Canvas canvas, Paint paint) {
                            paint.setColor(bgColor);
                            paint.setAntiAlias(true);
                            paint.setStyle(Paint.Style.FILL);
                            canvas.drawRoundRect(new RectF(v.getLeft(), v.getTop(), v.getRight(), v.getBottom()), 36f, 36f, paint);
                        }
                    });
                    v.setBackgroundDrawable(shapeDrawable);
                }


                TextView tv = (TextView) v.findViewById(TEXT_VIEW_TIP);
                tv.setTextColor(textColor);
                tv.setText(pTip);
                return v;
            }
        }, pGravity);
    }

    public static void showTipCus(String pTip, int bgColor, int textColor) {
        showTipCus(pTip, Toast.LENGTH_SHORT, GRAVITY_DEFAULT, bgColor, textColor);
    }

    public static void showLongTipCus(String pTip, int bgColor, int textColor) {
        showTipCus(pTip, Toast.LENGTH_LONG, GRAVITY_DEFAULT, bgColor, textColor);
    }

    public static void showTipCusCenter(final String pTip, int bgColor, int textColor) {
        showTipCus(pTip, Toast.LENGTH_SHORT, Gravity.CENTER, bgColor, textColor);
    }

    public static void showLongTipCusCenter(final String pTip, int bgColor, int textColor) {
        showTipCus(pTip, Toast.LENGTH_LONG, Gravity.CENTER, bgColor, textColor);
    }

    // 《— 显示吐司 可以设置背景颜色和文字颜色

    // 显示吐司 传入布局id,和视图回调 —》

    public static void showTipCus(int layoutId, ViewCallBack pViewCallBack){
        showTipCus(Toast.LENGTH_SHORT, layoutId, pViewCallBack,GRAVITY_DEFAULT);
    }
    public static void showLongTipCus(int layoutId, ViewCallBack pViewCallBack){
        showTipCus(Toast.LENGTH_LONG, layoutId, pViewCallBack,GRAVITY_DEFAULT );
    }

    public static void showTipCusCenter(int layoutId, ViewCallBack pViewCallBack) {
        showTipCus(Toast.LENGTH_SHORT, layoutId, pViewCallBack, Gravity.CENTER);
    }

    public static void showLongTipCusCenter(int layoutId, ViewCallBack pViewCallBack) {
        showTipCus(Toast.LENGTH_LONG, layoutId, pViewCallBack, Gravity.CENTER);
    }

    // 《— 显示吐司 传入布局id,和视图回调

    /**
     * 视图回调接口，将视图(View)传入，处理后，再返回
     */
    public interface ViewCallBack {
        View getView(View v);
    }
    // 《— 显示自定义吐司
}
