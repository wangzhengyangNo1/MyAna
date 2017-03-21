package com.wzhy.myana.home;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.wzhy.myana.R;
import com.wzhy.myana.base.ActivityBase;
import com.wzhy.myana.general.utils.ToastUtil;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Create by wangzhengyang on 2017/3/17.
 * 主页
 */
public class ActivityMain extends ActivityBase {

    @BindView(R.id.click_me_btn)
    Button mClickMeBtn;
    @BindView(R.id.ok_btn)
    Button mOkBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }


    @Override
    protected void initContentView() {
        setContentView(R.layout.activity_main);
    }

    @OnClick({R.id.click_me_btn, R.id.ok_btn})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.click_me_btn:
                ToastUtil.showTip("点我");
                break;
            case R.id.ok_btn:
                ToastUtil.showTip("确定");
                break;
        }
    }
}
