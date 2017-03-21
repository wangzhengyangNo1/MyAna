package com.wzhy.myana.general.consts;

/**
 * Created by techfit on 2017/2/20.
 */

public enum ConstsHttp {
    DEBUG("http://"),RELEASE("http://");

    public String API;

    ConstsHttp(String api){
        this.API = api;
    }

    public final String API_IMG = API + "api/images/";//图片地址

    public final String IMG_PROFILE = API_IMG + "a.jpg";//用户头像地址



}
