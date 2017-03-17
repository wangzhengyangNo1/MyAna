package com.wzhy.myana.general.utils;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;

import com.wzhy.myana.AppAna;
import com.wzhy.myana.general.consts.ConstsHttp;
import com.wzhy.myana.general.consts.ConstsIntent;
import com.wzhy.myana.general.consts.ConstsShared;

/**
 * Created by wangzhengyang on 2017/2/20.
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
     */
    ConstsHttp HTTP = ConstsHttp.DEBUG;




}
