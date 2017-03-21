package com.wzhy.myana.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.wzhy.myana.general.utils.Util;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by wangzhengyang on 2017/3/17.
 */

public abstract class ActivityBase extends AppCompatActivity implements Util{

    private Unbinder mBind;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initContentView();
        mBind = ButterKnife.bind(this);
    }

    protected abstract void initContentView();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mBind.unbind();
    }
}
