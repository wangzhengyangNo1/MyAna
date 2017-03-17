package com.wzhy.myana.viewstest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.wzhy.myana.R;
import com.wzhy.myana.general.view.CusSimpleTextView;

public class ActivityCusTextViewTest extends AppCompatActivity {

    private CusSimpleTextView mCusTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cus_text_view_test);
        getSupportActionBar().hide();

        mCusTextView = (CusSimpleTextView) findViewById(R.id.cus_text_view);
        mCusTextView.setUnderline(true);
        mCusTextView.setAntiAlias(true);
        mCusTextView.setDither(false);

    }
}
