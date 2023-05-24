package com.codingcn.douyin.model;

import cn.hutool.core.map.MapUtil;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.http.Method;
import cn.hutool.json.JSONUtil;

import java.util.Map;

/**
 * 抖音请求封装
 *
 * @author liexuan
 * @date 2023-05-18 13:57
 **/
public class RequestWrapper {

    /**
     * 签名信息头
     */
    public static final String BYTE_AUTHORIZATION = "Byte-Authorization";

    /**
     * 当前抖音签名算法常量
     */
    public static final String SHA256_RSA = " SHA256-RSA2048 ";


    /**
     * 时间戳
     */
    private long timestamp = System.currentTimeMillis();

    /**
     * 随机字符串
     */
    private String nonce = RandomUtil.randomString(18);

    /**
     * 接口地址
     */
    private String uri;

    /**
     * 请求方式
     */
    private Method method;

    /**
     * 请求参数
     */
    private Map<String, String> params;

    /**
     * 是否需要签名
     */
    private boolean needSign = false;

    public RequestWrapper() {
    }

    public RequestWrapper(String uri, Method method, Map<String, String> params) {
        this.uri = uri;
        this.method = method;
        this.params = params;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public String getNonce() {
        return nonce;
    }

    public String getUri() {
        return uri;
    }

    public RequestWrapper setUri(String uri) {
        this.uri = uri;
        return this;
    }

    public Method getMethod() {
        return method;
    }

    public RequestWrapper setMethod(Method method) {
        this.method = method;
        return this;
    }

    public Map<String, String> getParams() {
        return params;
    }

    public RequestWrapper setParams(Map<String, String> params) {
        this.params = params;
        return this;
    }

    public boolean getNeedSign() {
        return needSign;
    }

    public RequestWrapper setNeedSign(boolean needSign) {
        this.needSign = needSign;
        return this;
    }

    public static String paramToSortStr(Map params) {
        if (MapUtil.isEmpty(params)) {
            return StrUtil.EMPTY;
        }
        return JSONUtil.toJsonStr(MapUtil.sort(params));
    }
}
