package com.wzhy.myana;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.wzhy.myana.general.utils.SpanUtil;
import com.wzhy.myana.general.utils.TextUtil;
import com.wzhy.myana.general.utils.Util;

public class ActivitySample extends AppCompatActivity implements Util {

    private TextView mTvPackage;
    private TextView mTipView;
    private TextView mSectionView;
    private TextView mTableText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample);

        // Example of a call to a native method
        TextView tv = (TextView) findViewById(R.id.sample_text);
        tv.setText(stringFromJNI());

        mTableText = (TextView) findViewById(R.id.table_text);
        mTvPackage = (TextView) findViewById(R.id.tv_package);
        mTipView = (TextView) findViewById(R.id.tip_view);
        mSectionView = (TextView) findViewById(R.id.section_view);

        //UseOfTextUtil();

        //useOfSpanUtil();
        Typeface tf = Typeface.createFromAsset(getAssets(), "fonts/迷你简雁翎.ttf");
        //Typeface.createFromFile(path);Typeface.createFromFile(new File(path));
        mTvPackage.setTypeface(tf);
//        SpanUtil.create()
//                .addSection("本来无一物，何处惹尘埃。")
//                .setForeColor(Color.BLUE)
//                .showIn(mTvPackage);
        useOfSpanUtil();
    }

    private void useOfSpanUtil() {
        SpanUtil.create()
                .addSection("这abc是") //添加一个字符串
                .addForeColorSection("红色", Color.RED) //添加前景色为红色的文字
                .addSection("字体，这是") //添加普通字符串
                .addForeColorSection("蓝色", Color.rgb(0x00, 0x00, 0xff)) //添加前景色为蓝色的文字
                .addSection("字体，这是")
                .addForeColorSection("绿色", 0xff00ff00) //添加前景色为绿色的文字
                .addSection("字体。")
                .setForeColor("这是", 0x90900090,false, SpanUtil.Which.ALL)//将所有"这是"渲染为紫色（0x90900090）
                .removeSpans("这是", 2) //移除下标2后第一个"这是"的Span样式
                .setForeColor("字体", Color.MAGENTA) //渲染最后一个"字体"的字体颜色为Color.MAGENTA
                //.clearSpans() //清除所有格式
                //.setAlign(Layout.Alignment.ALIGN_CENTER, 0, 1)//设置文字对齐方式
                //.addImage(R.mipmap.ic_launcher) //文字后添加图片
                .insertImage(this,R.mipmap.ic_launcher,3) //文字中插入图片
                .addStyleSection("加粗倾斜", Typeface.BOLD_ITALIC)
                .setForeColor("加粗倾斜",0xff6090f0)
                .showIn(mTvPackage); //显示到控件TextView中

        SpanUtil.create()
                .addSection("这是前景色") //添加普通字符串
                .setForeColor("前景色", Color.RED) //为"前景色"设置前景色
                .setForeColor(Color.BLUE,0,2) //为前两个字符设置前景色
                .addSection("，这是")
                .addBackColorSection("背景色",Color.MAGENTA) //添加带背景色的文字片段
                .addSection("，这是删除线")
                .setStrikethrough("删除线") //为文字片段"删除线"设置删除线
                .setForeColor("删除线",Color.LTGRAY) //设置文字颜色（前景色）
                .addSection("，市场价：")
                .addForeColorSection("￥29.99",Color.GRAY)  //添加带前景色的文字片段
                .setAbsSize("￥29.99",38) //设置绝对字体
                .setRelSize(".99",0.6f) //设置相对字体
                .setStrikethrough("￥29.99") //设置删除线
                .addSection("，本店：")
                .addForeColorSection("￥39.99",Color.RED)
                .setAbsSize("￥39.99",28)
                .setRelSize(".99",0.6f)
                .showIn(mTipView);

        SpanUtil.create().addSection("2")
                .addSuperSection("10") //添加上标
                .setRelSize("10",0.6f)
                .addSection(" = 1024，")
                .addSection("42 = 16")
                .setAsSuperscript("2") //设置为上标
                .setRelSize("2",0.6f)
                .showIn(mSectionView);


    }

    private void UseOfTextUtil() {
        TextUtil.create()
                .addSection("这是")
                .addTintSection("绿色", 0x00ff00)
                .addSection("字体，这是")
                .addTintSection("蓝色", 0x0000ff)
                .addSection("字体。")
                .showIn(mTvPackage);

        TextUtil.create()
                .addSection("这是红色字体0，这是蓝色字体，这是绿色字体。")
                .tint("红色", 0xff0000)
                .tint("蓝色", 0x0000ff)
                .tint("绿色", 0x00ff00)
                .tint("字体", Color.CYAN)
                .tint("这是", Color.MAGENTA)
                .showIn(mTipView);


        TextUtil.create()
                .addSection("aaddAACCDdAAlkioAaDFFFDdouOuDDcC")
                .tintIgnoreCase("aa", 0xff0000)
                .tintIgnoreCase("dd", 0x0000ff)
                .tintIgnoreCase("cc", 0x00ff00)
                .showIn(mSectionView);
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }
}
