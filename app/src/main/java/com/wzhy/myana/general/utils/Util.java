package com.wzhy.myana.general.utils;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;

import com.wzhy.myana.AppAna;
import com.wzhy.myana.general.consts.ConstsHttp;
import com.wzhy.myana.general.consts.ConstsIntent;
import com.wzhy.myana.general.consts.ConstsRequest;
import com.wzhy.myana.general.consts.ConstsShared;

/**
 * Created by wangzhengyang on 2017/2/20.
 * 用于统一调用常量
 */

public interface Util {

    /**
     * appContext
     */
    Context CONTEXT = AppAna.getApp().getApplicationContext();

    /**
     * LayoutInflater
     */
    LayoutInflater INFLATER = (LayoutInflater) CONTEXT.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    /**
     * Resources
     */
    Resources RES = CONTEXT.getResources();

//*//*//*//*//*//*//*//*//*//*//*//*//*//*//*//*//*//*//*//*//*//*//*//*//*//*//*//*//*//*//*//*//*//*//

    /**
     * ConstsShared中存放SharedPreferences常量(key)
     */
    interface SPKEYS extends ConstsShared{}

    /**
     * ConstsIntent中存放Intent常量(name)
     */
    interface INTENT extends ConstsIntent{}

    /**
     * ConstsHttp.DEBUG 调试版本
     * Constshttp.RELEASE 正式版本
     * Util.HTTP. 获取网络请求接口
     */
    ConstsHttp HTTP = ConstsHttp.DEBUG;

    /**
     * ConstsRequest中存放的常量（关于网络请求的常量）
     */
    interface REQUEST extends ConstsRequest{}

}
