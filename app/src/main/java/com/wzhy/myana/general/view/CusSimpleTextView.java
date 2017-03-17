package com.wzhy.myana.general.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.ColorInt;
import android.support.annotation.Dimension;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.wzhy.myana.R;
import com.wzhy.myana.general.utils.DisplayUtil;

/**
 * Created by wangzhengyang on 2017/3/6.
 */

public class CusSimpleTextView extends View {
    //文字内容
    private String mTextContent;
    //文字颜色
    private int mTextColor;
    //文字大小
    private int mTextSize;
    private Paint mPaint;
    private Rect mBound;

    public CusSimpleTextView(Context context) {
        this(context, null);
    }

    public CusSimpleTextView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CusSimpleTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        //获得自定义的属性
        TypedArray typedArray = context.getTheme().obtainStyledAttributes(attrs, R.styleable.attrs_cus_tv, defStyleAttr, 0);

        int indexCount = typedArray.getIndexCount();

        for (int i = 0; i < indexCount; i++) {
            int index = typedArray.getIndex(i);
            switch (index) {
                case R.styleable.attrs_cus_tv_textContent:
                    mTextContent = typedArray.getString(index);
                    break;
                case R.styleable.attrs_cus_tv_textColor:
                    mTextColor = typedArray.getColor(index, Color.BLACK);
                    break;
                case R.styleable.attrs_cus_tv_textSize:
                    //默认设置为14sp,将DisplayUtil将sp转为px
                    mTextSize = (int) typedArray.getDimension(index, DisplayUtil.sp2pxF(14));
//                    // 默认设置为16sp，TypeValue也可以把sp转化为px
//                    mTextSize = typedArray.getDimensionPixelSize(index, (int) TypedValue.applyDimension(
//                            TypedValue.COMPLEX_UNIT_SP, 16, getResources().getDisplayMetrics()));
                    break;
            }
        }
        typedArray.recycle();

        mPaint = new Paint();
        mPaint.setTextSize(mTextSize);
        mPaint.setStrikeThruText(true);

        mBound = new Rect();
        mPaint.getTextBounds(mTextContent, 0, mTextContent.length(), mBound);

        this.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (record) {
                    case 0:
                        mTextColor = Color.BLUE;

                        record = 1;
                        break;
                    case 1:
                        mTextColor = Color.RED;
                        record = 0;
                        break;
                }
                mPaint.setColor(Color.BLUE);
                postInvalidate();
            }
        });
    }

    private int record = 0;

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);

        int width = 0;
        int height = 0;
        //宽度设置
        switch (widthMode) {
            case MeasureSpec.EXACTLY://明确指定
                width = getPaddingLeft() + getPaddingRight() + widthSize;
                break;
            case MeasureSpec.AT_MOST://一般为wrap_content
                width = getPaddingLeft() + getPaddingLeft() + mBound.width();
                break;
        }
        //高度设置
        switch (heightMode) {
            case MeasureSpec.EXACTLY://明确指定
                height = getPaddingTop() + getPaddingBottom() + heightSize;
                break;
            case MeasureSpec.AT_MOST://一般为wrap_content
                height = getPaddingTop() + getPaddingBottom() + mBound.height();
                break;
        }

        setMeasuredDimension(width, height);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        mPaint.setColor(Color.YELLOW);
//        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(2.0f);
        canvas.drawRect(0, 0, getMeasuredWidth(), getMeasuredHeight(), mPaint);

//        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setColor(mTextColor);
        Log.i("CusTextView", "onDraw: getHeight(): " + getHeight() + ", mBound.height(): " + mBound.height());
        canvas.drawText(mTextContent, getWidth() / 2 - mBound.width() / 2, getHeight() / 2 + mBound.height() / 2 - 2, mPaint);

    }

    /**
     * 是否设置下划线
     * @param isIt
     */
    public void setUnderline(boolean isIt) {
        setTextDecor(Paint.UNDERLINE_TEXT_FLAG, isIt);
    }

    /**
     * 设置文字
     * @param textContent
     */
    public void setTextContent(String textContent){
        if (null == textContent) return;
        mTextContent = textContent;
        postInvalidate();
    }

    public void setTextColor(@ColorInt int color){
        this.mTextColor = color;
        postInvalidate();
    }

    public void setTextSize(@Dimension int size){
        this.mTextSize = size;
        postInvalidate();
    }



    /**
     * 设置删除线
     * @param isIt
     */
    public void setStrikeThru(boolean isIt){
        setTextDecor(Paint.STRIKE_THRU_TEXT_FLAG,isIt);
    }

    public void setAntiAlias(boolean isIt){
        setTextDecor(Paint.ANTI_ALIAS_FLAG,isIt);
    }

    public void setDither(boolean isIt){
        setTextDecor(Paint.DITHER_FLAG,isIt);
    }

    public void setFakeBold(boolean isIt){
        setTextDecor(Paint.FAKE_BOLD_TEXT_FLAG,isIt);
    }

    public void setLinear(boolean isIt){
        setTextDecor(Paint.LINEAR_TEXT_FLAG,isIt);
    }

    public void setSubpixel(boolean isIt){
        setTextDecor(Paint.SUBPIXEL_TEXT_FLAG,isIt);
    }

    public void setFilterBitmap(boolean isIt){
        setTextDecor(Paint.FILTER_BITMAP_FLAG,isIt);
    }

    public void setTextDecor(int flag, boolean isIt) {
        switch (flag) {
            case Paint.ANTI_ALIAS_FLAG:
                mPaint.setAntiAlias(isIt);
                break;
            case Paint.UNDERLINE_TEXT_FLAG:
                mPaint.setUnderlineText(isIt);
                break;
            case Paint.STRIKE_THRU_TEXT_FLAG:
                mPaint.setStrikeThruText(isIt);
                break;
            case Paint.DITHER_FLAG:
                mPaint.setDither(isIt);
            case Paint.FAKE_BOLD_TEXT_FLAG:
                mPaint.setFakeBoldText(isIt);
                break;
            case Paint.LINEAR_TEXT_FLAG:
                mPaint.setLinearText(isIt);
                break;
            case Paint.SUBPIXEL_TEXT_FLAG:
                mPaint.setSubpixelText(isIt);
                break;
            case Paint.FILTER_BITMAP_FLAG:
                mPaint.setFilterBitmap(isIt);
                break;
        }
        postInvalidate();
    }

}
