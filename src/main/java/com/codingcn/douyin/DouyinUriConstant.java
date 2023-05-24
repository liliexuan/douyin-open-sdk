package com.codingcn.douyin;

/**
 * 抖音调用地址URI常量
 *
 * @author liexuan
 * @date 2023-05-18 17:11
 **/
public class DouyinUriConstant {

    /**
     * 获取接口调用凭证
     * https://developer.open-douyin.com/docs/resource/zh-CN/mini-app/develop/server/interface-request-credential/get-access-token
     */
    public static final String GET_ACCESS_TOKEN_URI = "/api/apps/v2/token";


    /**
     * 小程序登录接口
     * https://developer.open-douyin.com/docs/resource/zh-CN/mini-app/develop/server/log-in/code-2-session
     */
    public static final String GET_CODE2SESSION_URI = "/api/apps/v2/jscode2session";
}
