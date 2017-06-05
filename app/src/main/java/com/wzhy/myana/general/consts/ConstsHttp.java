package com.wzhy.myana.general.consts;

/**
 * Created by wangzhengyang on 2017/2/20.
 * 用于保存网络请求的接口
 * 所有网络请求接口都应该是
 * public final String
 * 不需要静态
 */

public enum ConstsHttp {

    DEBUG(1),RELEASE(2);

    private int FLAG;

    ConstsHttp(int flag){
        this.FLAG = flag;
    }

    // 线下服务器开关
    public final boolean IS_DEBUG = (FLAG == 1);

    // 测试环境地址
    public final String URL_DEBUG_IP = "http://114.215.130.56:8080/";
    public final String URL_DEBUG_IMAGE_IP = "http://114.215.130.56:8080/gym-api/";
    public final String URL_DEBUG_IP_WEB = "http://114.215.130.56:8080/gym-web/";

    // 正式环境地址
    public final String URL_ONLINE_IP = "http://king.techfit.cn/";
    public final String URL_ONLINE_IMAGE_IP = "http://king.techfit.cn/gym-api/";
    public final String URL_ONLINE_IP_WEB = "http://web.techfit.cn/gym-web/";

    // 发版实际使用地址
    public final String IP = IS_DEBUG ? URL_DEBUG_IP : URL_ONLINE_IP;
    public final String IMAGE_IP = IS_DEBUG ? URL_DEBUG_IMAGE_IP : URL_ONLINE_IMAGE_IP;
    public final String IP_WEB = IS_DEBUG ? URL_DEBUG_IP_WEB : URL_ONLINE_IP_WEB;

    public final String LOGIN = "gym_api/login";

    public final String LOGOUT = "gym_api/logout";





}
